package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLBaseVisitor;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.AndexpressionContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.ConditionalContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.ConditionalSetContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.FloatingpointContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.FormulaInBracketsContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.FractionContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.NotAtomContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.OrexpressionContext;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.antlr4.PCLParser.SingleAtomContext;

/**
 * Abstract class for Visitors. Type V represents the variable class, type F is
 * represents Formulas and type C is for conditionals.
 */
public abstract class AbstractVisitor<V, F, C> extends PCLBaseVisitor<F>
		implements IVisitor<V, C> {

	/**
	 * Variables are stored in an OrderesHashMap Object with variable name as
	 * key and variable object of type V as value.
	 */
	private OrderedHashMap<String, V> variables = new OrderedHashMap<String, V>();

	/**
	 * Conditionals are stored in an OrderenHashMap Object with conditionalset
	 * name as key and an ArrayList object as value. The ArrayList can store
	 * conditionals of type C
	 */
	private OrderedHashMap<String, Collection<C>> conditionals = new OrderedHashMap<String, Collection<C>>();

	/**
	 * Is used for creating a conditional object
	 */
	private Stack<C> conditionalMemory = new Stack<C>();

	/**
	 * Is used for creating a conditional object with probability
	 */
	private Stack<Fraction> probabilityMemory = new Stack<Fraction>();

	/**
	 * Default constructor that does essentially nothing.
	 * 
	 * Commands are disabled by default.
	 */
	public AbstractVisitor() {
	}

	@Override
	public F visitMultivaluedVar(@NotNull PCLParser.MultivaluedVarContext ctx) {
		String varName = ctx.varName().getText();
		String[] values = new String[ctx.varValue().size()];
		for (int n = 0; n < values.length; n++) {
			values[n] = ctx.varValue().get(n).getText();
		}
		V mulValVar = createMultivaluedVar(varName, values);
		variables.put(varName, mulValVar);
		return visitChildren(ctx);
	}

	/**
	 * Called by AbstractVisitor to create a multivalued variable if the parser
	 * visits one.
	 * 
	 * @param varName
	 *            Name of the Variable
	 * @param varValues
	 *            Value array
	 * @return A new variable object of type V
	 */
	protected abstract V createMultivaluedVar(String varName,
			String... varValues);

	@Override
	public F visitConditionals(@NotNull PCLParser.ConditionalsContext ctx) {
		for (ConditionalSetContext i : ctx.conditionalSet()) {
			if (!conditionals.containsKey(i.conditionalSetName().getText())) {
				conditionals.put(i.conditionalSetName().getText(),
						new ArrayList<C>());
			}
			for (ConditionalContext j : i.conditional()) {
				visit(j);
				conditionals.get(i.conditionalSetName().getText()).add(
						conditionalMemory.pop());
			}
		}
		return null;
	}

	@Override
	public F visitOrexpression(OrexpressionContext ctx) {
		F orFormula = visit(ctx.andexpression(0));
		if (ctx.andexpression().size() > 1) {
			// starting at 1 because 0 is already f1
			for (int andexNo = 1; andexNo < ctx.andexpression().size(); andexNo++) {
				orFormula = or(orFormula, visit(ctx.andexpression(andexNo)));
			}
		}
		return orFormula;
	}

	/**
	 * Called by AbstractVisitor to disjunct two formulas
	 * 
	 * @param formula1
	 * @param formula2
	 * @return A new formula Object of type F
	 */
	protected abstract F or(F formula1, F formula2);

	@Override
	public F visitFormulaInBrackets(FormulaInBracketsContext ctx) {
		return visit(ctx.formula());
	}

	@Override
	public F visitNotAtom(NotAtomContext ctx) {
		return not(visit(ctx.atom()));
	}

	/**
	 * Called by AbstractVisitor to negate a formula
	 * 
	 * @param formula
	 * @return A new formula Object of type F
	 */
	protected abstract F not(F formula);

	@Override
	public F visitSingleAtom(SingleAtomContext ctx) {
		return visit(ctx.atom());
	}

	@Override
	public F visitAndexpression(AndexpressionContext ctx) {
		F andFormula = visit(ctx.notexpression(0));
		if (ctx.notexpression().size() > 1) {
			// starting at 1 because 0 is already f1
			for (int notexNo = 1; notexNo < ctx.notexpression().size(); notexNo++) {
				andFormula = and(andFormula, visit(ctx.notexpression(notexNo)));
			}
		}
		return andFormula;
	}

	/**
	 * Called by AbstractVisitor to conjunct two formulas
	 * 
	 * @param formula1
	 * @param formula2
	 * @return A new formula Object of type F
	 */
	protected abstract F and(F formula1, F formula2);

	@Override
	public F visitVarName(@NotNull PCLParser.VarNameContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public F visitVarValue(@NotNull PCLParser.VarValueContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public F visitBinaryVar(@NotNull PCLParser.BinaryVarContext ctx) {
		String varName = ctx.varName().getText();
		variables.put(varName, createBinaryVar(varName));
		return visitChildren(ctx);
	}

	/**
	 * Called by AbstractVisitor to create a boolean variable
	 * 
	 * @param varName
	 * @return new variable object of type V
	 */
	protected abstract V createBinaryVar(String varName);

	@Override
	public F visitAtomWithoutAlloc(
			@NotNull PCLParser.AtomWithoutAllocContext ctx) {
		F p = allocateTrueToVariable(variables.get(ctx.varName().getText()));
		return p;
	}

	/**
	 * Allocates true to a boolean variable and forms it to a formula object of
	 * type F
	 * 
	 * @param variable
	 * @return new formula object of type F
	 */
	protected abstract F allocateTrueToVariable(V variable);

	@Override
	public F visitConditionalSetName(
			@NotNull PCLParser.ConditionalSetNameContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public F visitAtomWithAlloc(@NotNull PCLParser.AtomWithAllocContext ctx) {
		F p = allocateValueToVariable(variables.get(ctx.varName().getText()),
				ctx.varValue().getText());
		return p;
	}

	/**
	 * Allocates a value to a variable and forms it to a formula object of type
	 * F
	 * 
	 * @param variable
	 * @param value
	 * @return New formula object of type F
	 */
	protected abstract F allocateValueToVariable(V variable, String value);

	@Override
	public F visitFormulaWithProbability(
			@NotNull PCLParser.FormulaWithProbabilityContext ctx) {
		visit(ctx.probability());
		C c = createFactWithProbability(visit(ctx.formula()),
				probabilityMemory.pop());
		conditionalMemory.add(c);
		return null;
	}

	/**
	 * Creates a fact as conditional object with a probability
	 * 
	 * @param formula
	 * @param probability
	 * @return new conditional object of type C
	 */
	protected abstract C createFactWithProbability(F formula,
			Fraction probability);

	@Override
	public F visitFormulaWithoutProbability(
			@NotNull PCLParser.FormulaWithoutProbabilityContext ctx) {
		C c = createFactWithoutProbability(visit(ctx.formula()));
		conditionalMemory.add(c);
		return null;
	}

	/**
	 * Creates a fact as conditional without probability
	 * 
	 * @param formula
	 * @return mew conditional object of type C
	 */
	protected abstract C createFactWithoutProbability(F formula);

	@Override
	public F visitConditionalWithoutProbability(
			@NotNull PCLParser.ConditionalWithoutProbabilityContext ctx) {
		C c = createConditionalWithoutProbability(visit(ctx.formula(0)),
				visit(ctx.formula(1)));
		conditionalMemory.add(c);
		return null;
	}

	/**
	 * Creates a conditional with consequence and antecedence as formulas
	 * 
	 * @param consequence
	 * @param antecedence
	 * @return new conditional object of type C
	 */
	protected abstract C createConditionalWithoutProbability(F consequence,
			F antecedence);

	@Override
	public F visitConditionalWithProbability(
			@NotNull PCLParser.ConditionalWithProbabilityContext ctx) {
		visit(ctx.probability());
		C c = createConditionalWithProbability(visit(ctx.formula(0)),
				visit(ctx.formula(1)), probabilityMemory.pop());
		conditionalMemory.add(c);
		return null;
	}

	/**
	 * Creates a conditional with probability with consequence and antecedence
	 * as formulas
	 * 
	 * @param consequence
	 * @param antecedence
	 * @param probability
	 * @return new conditional object of type C
	 */
	protected abstract C createConditionalWithProbability(F consequence,
			F antecedence, Fraction probability);

	@Override
	public F visitFraction(FractionContext ctx) {
		int num = Integer.valueOf(ctx.NUMBER(0).getText());
		int denom = Integer.valueOf(ctx.NUMBER(1).getText());

		Fraction p = new Fraction(num, denom);

		if (p.toFloatingPoint() > 1) {
			throw new IllegalArgumentException("Invalid Input: "
					+ ctx.getText()
					+ ". Probabilities can't be greater than 1.");
		} else {
			probabilityMemory.push(p);
		}
		return null;
	}

	@Override
	public F visitFloatingpoint(FloatingpointContext ctx) {
		double p = Double.valueOf(ctx.getText());
		if (p > 1) {
			throw new IllegalArgumentException("Invalid Input: "
					+ ctx.getText()
					+ ". Probabilities can't be greater than 1.");
		} else {
			probabilityMemory.push(new Fraction(p));
		}
		return null;
	}

	@Override
	public void visitTree(ParseTree tree) {
		this.visit(tree);
	}

	@Override
	public Map<String, V> getVariables() {
		return variables;
	}

	@Override
	public Map<String, Collection<C>> getKnowledgeBases() {
		return conditionals;
	}
}
