package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLBaseVisitor;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.AndexpressionContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.CondContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.ConditionalContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.Conditionals_bodyContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.ConstantContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.ConstraintInBracketsContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.Constraint_andexpressionContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.Constraint_orexpressionContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.EqualityConstraintContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.FactContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.FormulaInBracketsContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.InequalityConstraintContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.Knowledge_baseContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.NotAtomContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.NotConstraintAtomContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.OrexpressionContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.PredicateWithSortsContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.PredicateWithTermsContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.PredicateWithoutSortsContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.PredicateWithoutTermsContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.SignatureContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.SingleAtomContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.SingleConstraintAtomContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.SortContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.Sort_nameContext;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.antlr4.RCLParser.TermContext;

/**
 * 
 * @author koecher
 *
 * @param <SORT>
 * @param <TERM>
 * @param <CONSTANT>
 * @param <VARIABLE>
 * @param <PREDICATE>
 * @param <CONDITIONAL>
 * @param <FORMULA>
 * @param <CONSTRAINT>
 */

public abstract class AbstractVisitor<SORT,TERM,CONSTANT,VARIABLE,PREDICATE,CONDITIONAL,FORMULA,CONSTRAINT> extends RCLBaseVisitor<FORMULA> implements IVisitor<SORT, CONSTANT, VARIABLE, PREDICATE, CONDITIONAL>{
	//Sort
	protected Map<String, SORT> sorts;
	//Constants
	protected Map<String, CONSTANT> constants;
	//Variables
	protected Map<String, VARIABLE> variables;
	//Predicates
	protected Map<String, PREDICATE> predicates;
	//Conditionals
	//The key is ConditionalsContext because conditionals don't have a
	//name which could be used to refer to the conditional
	protected Map<ConditionalContext, CONDITIONAL> conditionals;
	//Knowledge Bases
	protected Map<String, Collection<CONDITIONAL>> knowledgeBases;
	
	public AbstractVisitor() {
		// Used LinkedHashMaps because they are ordered.
		sorts = new LinkedHashMap<String, SORT>();
		constants = new LinkedHashMap<String, CONSTANT>();
		variables = new LinkedHashMap<String, VARIABLE>();
		predicates = new LinkedHashMap<String, PREDICATE>();
		conditionals = new LinkedHashMap<ConditionalContext, CONDITIONAL>();
		knowledgeBases = new LinkedHashMap<String, Collection<CONDITIONAL>>();
	}

	
	
	//////////////////
	//// Signature ///
	//////////////////
	
	// Sorts and constants
	
	@Override
	public FORMULA visitSignature(SignatureContext ctx) {
		for(SortContext sort : ctx.sort()){
			//For every Sort, create an SORT Object and store it in sorts map
			String currentSortName = sort.sort_name().getText();
			SORT currentSort = createSort(currentSortName);
			sorts.put(currentSortName, currentSort);
			for(ConstantContext constant : sort.constant()){
				// Create new CONSTANT Object for all constants in that sort and store in constants map
				String currentConstantName = constant.getText();
				constants.put(currentConstantName, createConstant(currentConstantName, currentSort));
			}
		}
		//Visit predicates
		return visitChildren(ctx);
	}
	
	//Predicates
	
	@Override
	public FORMULA visitPredicateWithoutSorts(PredicateWithoutSortsContext ctx) {
		// if there is a predicate without sorts, create a predicate objects using an empty ArrayList
		// and store it in predicates map
		String predicate_name = ctx.predicate_name().getText();
		predicates.put(predicate_name, createPredicate(predicate_name, new ArrayList<SORT>()));
		return null;
	}
	
	@Override
	public FORMULA visitPredicateWithSorts(PredicateWithSortsContext ctx) {
		//if threre is a predicate with sorts, find it in the sorts map and create a new predicate object
		// and store it in predicates map
		String predicate_name = ctx.predicate_name().getText();
		Collection<SORT> arguments = new ArrayList<SORT>();
		for(Sort_nameContext sort : ctx.sort_name()){
			if(sorts.containsKey(sort.getText())){
				arguments.add(this.sorts.get(sort.getText()));
			} else {
				elementNotDefined("Sort", sort.getText());
			}
		}
		predicates.put(predicate_name, createPredicate(predicate_name, arguments));
		return null;
	}

	// abstracts
	
	protected abstract SORT createSort(String sort_name);
	protected abstract CONSTANT createConstant(String constant_name, SORT sort);
	protected abstract PREDICATE createPredicate(String predicate_name, Collection<SORT> arguments);
	
	
	
	/////////////////////
	//// Conditionals ///
	/////////////////////
	
	// Fact
	
	@Override
	public FORMULA visitFact(FactContext ctx) {
		FORMULA consequence = visit(ctx.formula());
		
		Fraction p = null;
		
		//if user entered a probability it'll be stored in a fraction object
		if(ctx.probability() != null){
			if(!(ctx.probability().fraction() == null)){
				p = new Fraction(Integer.valueOf(ctx.probability().fraction().NUMBER(0).getText()), 
						Integer.valueOf(ctx.probability().fraction().NUMBER(1).getText()));
			} else {
				p = new Fraction(Double.valueOf(ctx.probability().floatingpoint().getText()));
			}
		}
		
		//if user entered a constraint, then the constraint function will be executed and returns a formula object
		FORMULA constraint = null;
		if(ctx.constraint() != null){
			constraint = visit(ctx.constraint());
		}
		
		//create an conditional object with just a consequence (Fact) with the given probability and constraints
		//and store in conditionals map
		conditionals.put(ctx, createFact(consequence, p, constraint));
		return null;
	}
	
	// Conditional
	
	@Override
	public FORMULA visitCond(CondContext ctx) {
		FORMULA consequence = visit(ctx.formula(0));
		FORMULA antecedence = visit(ctx.formula(1));
		
		Fraction p = null;
		if(ctx.probability() != null){
			if(ctx.probability().fraction() != null){
				p = new Fraction(Integer.valueOf(ctx.probability().fraction().NUMBER(0).getText()), 
						Integer.valueOf(ctx.probability().fraction().NUMBER(1).getText()));
			} else {
				p = new Fraction(Double.valueOf(ctx.probability().floatingpoint().getText()));
			}
		}
		
		FORMULA constraint = null;
		
		if(ctx.constraint() != null){
			constraint = visit(ctx.constraint());
		}
		
		conditionals.put(ctx, createConditional(consequence, antecedence, p, constraint));
		return null;
	}
	
	@Override
	public FORMULA visitConditionals_body(Conditionals_bodyContext ctx) {
		//if there are multiple knowledge bases, every knowledge base and its conditionals are stored
		//in the knowledgeBases map
		if(ctx.knowledge_bases() != null){
			for(Knowledge_baseContext kb : ctx.knowledge_bases().knowledge_base()){
				String kbName = kb.knowledge_base_name().getText();
				Collection<CONDITIONAL> kbConditionals = new ArrayList<CONDITIONAL>();
				
				for(ConditionalContext conditional : kb.knowledge_base_body().conditional()){
					visit(conditional);
					kbConditionals.add(conditionals.get(conditional));
				}
				
				knowledgeBases.put(kbName, kbConditionals);
			}
		} else if(ctx.knowledge_base_body() != null){
			for(ConditionalContext conditional : ctx.knowledge_base_body().conditional()){
				visit(conditional);
			}
		}
		return null;
	}
	
	// abstracts
	
	/**
	 * Creates and returns a new CONDITIONAL object and is used in this visitor when it finds a Fact.
	 * Parameters probability and constraint can be null.
	 * 
	 * @param consequence
	 * @param probability can be null
	 * @param constraint can be null
	 * @return a new object of type CONDITIONAL representing a fact.
	 */
	protected abstract CONDITIONAL createFact(FORMULA consequence, Fraction probability, FORMULA constraint);
	

	/**
	 * Creates and returns a new CONDITIONAL object and is used in this visitor when it finds a Condtional.
	 * Parameters probability and constraint can be null.
	 * 
	 * @param consequence
	 * @param antecedence
	 * @param probability
	 * @param constraint
	 * @return a new object of type CONDITIONAL.
	 */
	protected abstract CONDITIONAL createConditional(FORMULA consequence, FORMULA antecedence, Fraction probability, FORMULA constraint);
	
	
	/////////////////////////////
	//// Constaint operations ///
	/////////////////////////////
	
	@Override
	public FORMULA visitConstraintInBrackets(ConstraintInBracketsContext ctx) {
		return visit(ctx.constraint());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public FORMULA visitEqualityConstraint(EqualityConstraintContext ctx) {
		VARIABLE var = null;
		TERM t = null;

		//get the variable object
		if(variables.containsKey(ctx.variable_name().getText())){
			var = variables.get(ctx.variable_name().getText());
		} else {
			elementNotDefined("Variable", ctx.variable_name().getText());
		}
		
		String termName = ctx.term().getText();
		
		//get the constant or variable object
		if(constants.containsKey(termName)){
			t = (TERM) constants.get(termName);
		} else if(variables.containsKey(termName)) {
			t = (TERM) variables.get(termName);
		} else {
			elementNotDefined("Constant/Variable", termName);
		}
		//create equality constraint and return it
		return createEqualityConstraint(var, t);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public FORMULA visitInequalityConstraint(InequalityConstraintContext ctx) {
		VARIABLE var = null;
		TERM t = null;
		
		//get the variable
		if(variables.containsKey(ctx.variable_name().getText())){
			var = variables.get(ctx.variable_name().getText());
		} else {
			elementNotDefined("Variable", ctx.variable_name().getText());
		}
		
		String termName = ctx.term().getText();
		
		//get the constant or variable object
		if(constants.containsKey(termName)){
			t = (TERM) constants.get(termName);
		} else if(variables.containsKey(termName)) {
			t = (TERM) variables.get(termName);
		} else {
			elementNotDefined("Constant/Variable", termName);
		}
		
		//create inequality constraint and return it.
		return createInequalityConstraint(var, t);
	}
	
	@Override
	public FORMULA visitSingleConstraintAtom(SingleConstraintAtomContext ctx) {
		return visit(ctx.constraint_atom());
	}
	
	@Override
	public FORMULA visitNotConstraintAtom(NotConstraintAtomContext ctx) {
		return not(visitChildren(ctx));
	}
	
	@Override
	public FORMULA visitConstraint_orexpression(
			Constraint_orexpressionContext ctx) {
		//get the first formula and store in orFormula
		FORMULA orFormula = visit(ctx.constraint_andexpression(0));
		
		//remember the parser works as following (ex=expression):
		//formula = orex;
		//orex = andex or [none or more] andex
		//andex = notex and [none or more] notex
		//notex = atom or notatom
		
		//So if there are more than one andexpressions linked by orexpression...
		if(ctx.constraint_andexpression().size()>1){
			//starting at 1 because at 0 is already the first formula
			//... then visit all the andexpressions and link them with or
			for(int andexNo=1; andexNo < ctx.constraint_andexpression().size(); andexNo++){
				orFormula = or(orFormula, visit(ctx.constraint_andexpression(andexNo)));
			}
		}
		return orFormula;
	}
	
	@Override
	public FORMULA visitConstraint_andexpression(
			Constraint_andexpressionContext ctx) {

		//get first formula and store in andFormula
		FORMULA andFormula = visit(ctx.constraint_notexpression(0));
		
		//remember the parser works as following (ex=expression):
		//formula = orex;
		//orex = andex or [none or more] andex
		//andex = notex and [none or more] notex
		//notex = atom or notatom
		
		//So if there are more than one notexpressions linked by andexpression...
		if(ctx.constraint_notexpression().size()>1){
			//starting at 1 because 0 is already f1
			//... then visit all the notexpressions and link them with and
			for(int notexNo=1; notexNo < ctx.constraint_notexpression().size(); notexNo++){
				andFormula = and(andFormula, visit(ctx.constraint_notexpression(notexNo)));
			}
		}
		return andFormula;
	}
	
	
	// abstracts

	/**
	 * Creates and returns a new FORMULA object and is used in this visitor when it finds an equality constraint.
	 * 
	 * @param v The variable.
	 * @param t The constant or variable which is assigned to the variable v.
	 * @return A new object of type FORMULA representing an equality constraint.
	 */
	protected abstract FORMULA createEqualityConstraint(VARIABLE v, TERM t);
	
	/**
	 * Creates and returns a new FORMULA object and is used in this visitor when it finds an inequality constraint.
	 * 
	 * @param v The variable
	 * @param t The constant or variable which is assigned to the variable v.
	 * @return
	 */
	protected abstract FORMULA createInequalityConstraint(VARIABLE v, TERM t);
	
	///////////////////////////
	//// Formula operations ///
	///////////////////////////
	
	@Override
	public FORMULA visitNotAtom(NotAtomContext ctx) {
		return not(visit(ctx.atom()));
	}
	
	@Override
	public FORMULA visitSingleAtom(SingleAtomContext ctx) {
		return visit(ctx.atom());
	}
	
	@Override
	public FORMULA visitPredicateWithoutTerms(PredicateWithoutTermsContext ctx) {
		PREDICATE pred = null;
		
		//Get the predicate object
		if(predicates.containsKey(ctx.predicate_name().getText())){
			pred = predicates.get(ctx.predicate_name().getText());
		} else {
			elementNotDefined("Predicate", ctx.predicate_name().getText());
		}
		
		//create an atom object from the predicate object with an empty arraylist, because there are no terms
		return createAtom(pred, new ArrayList<TERM>());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public FORMULA visitPredicateWithTerms(PredicateWithTermsContext ctx) {
		Collection<TERM> terms = new ArrayList<TERM>();
		//Get all terms
		TermContext[] termContexts = ctx.term().toArray(new TermContext[ctx.term().size()]);
		PREDICATE pred = null;
		
		//Get preciate object
		if(predicates.containsKey(ctx.predicate_name().getText())){
			pred = predicates.get(ctx.predicate_name().getText());
		} else {
			elementNotDefined("Predicate", ctx.predicate_name().getText());
		}
		
		for(int termNumber = 0; termNumber < termContexts.length; termNumber++){
			String termString = termContexts[termNumber].getText();
			// Check if Term is a variable or constant
			if(constants.containsKey(termString)){
				terms.add((TERM) constants.get(termString));
			} else if(isVariable(termString)) {
				VARIABLE v = createVariable(termString,	getSortFromTermPosition(pred, termNumber));

				variables.put(termString,v);
				terms.add((TERM) v);
			} else {
				throw new IllegalArgumentException("Constant/Variable " + termString + " is not defined.");
			}
		}
		
		//create new object of type FORMULA from pred with terms
		return createAtom(pred, terms);
	}
	
	@Override
	public FORMULA visitFormulaInBrackets(FormulaInBracketsContext ctx) {
		return visit(ctx.formula());
	}
	
	@Override
	public FORMULA visitOrexpression(OrexpressionContext ctx) {
		FORMULA orFormula = visit(ctx.andexpression(0));
		
		//remember the parser works as following (ex=expression):
		//formula = orex;
		//orex = andex or [none or more] andex
		//andex = notex and [none or more] notex
		//notex = atom or notatom
		
		//So if there are more than one andexpression linked by orexpressions,
		//visit all andexpressions and link them with or
		if(ctx.andexpression().size()>1){
			//starting at 1 because 0 is already f1
			for(int andexNo=1; andexNo < ctx.andexpression().size(); andexNo++){
				orFormula = or(orFormula, visit(ctx.andexpression(andexNo)));
			}
		}
		return orFormula;
	}
	
	@Override
	public FORMULA visitAndexpression(AndexpressionContext ctx) {
		FORMULA andFormula = visit(ctx.notexpression(0));
		
		//remember the parser works as following (ex=expression):
		//formula = orex;
		//orex = andex or [none or more] andex
		//andex = notex and [none or more] notex
		//notex = atom or notatom
		
		//So if there are more than one notexpressions linked by andexpression,
		//visit all notexpressions and link them with and
		if(ctx.notexpression().size()>1){
			//starting at 1 because 0 is already f1
			for(int notexNo=1; notexNo < ctx.notexpression().size(); notexNo++){
				andFormula = and(andFormula, visit(ctx.notexpression(notexNo)));
			}
		}
		return andFormula;
	}
	
	// abstracts
	
	protected abstract FORMULA not(FORMULA f);
	protected abstract FORMULA createAtom(PREDICATE predicate, Collection<TERM> terms);
	protected abstract FORMULA or(FORMULA f1, FORMULA f2);
	protected abstract FORMULA and(FORMULA f1, FORMULA f2);
	protected abstract VARIABLE createVariable(String constant_name, SORT sort);
	protected abstract SORT getSortFromTermPosition(PREDICATE predicate, int termPosition);
	
	
	////////////////
	//// Visitor ///
	////////////////
	
	@Override
	public void visitTree(ParseTree tree) {
		this.visit(tree);
	}
	
	/////////////////////////////
	//// additional functions ///
	/////////////////////////////
	
	private boolean isVariable(String varName){
		//The first letter of an variable is upper case
		return (Character.isUpperCase(varName.charAt(0)));
	}
	
	protected void elementNotDefined(String type, String element){
		throw new IllegalArgumentException(type + " " + element + " is not defined!");
	}
	
	////////////////
	//// getter  ///
	////////////////


	@Override
	public Map<String, PREDICATE> getPredicates() {
		return predicates;
	}

	

	@Override
	public Map<ConditionalContext, CONDITIONAL> getConditionals() {
		return conditionals;
	}



	@Override
	public Map<String, Collection<CONDITIONAL>> getKnowledgeBases() {
		return knowledgeBases;
	}


	@Override
	public Map<String, SORT> getSorts() {
		return sorts;
	}



	@Override
	public Map<String, CONSTANT> getConstants() {
		return constants;
	}



	@Override
	public Map<String, VARIABLE> getVariables() {
		return variables;
	}
}

