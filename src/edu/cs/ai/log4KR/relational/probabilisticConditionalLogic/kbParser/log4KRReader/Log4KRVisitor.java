package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.log4KRReader;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.AtomicConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.EqualityConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.InequalityConstraint;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Sort;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Term;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.AbstractVisitor;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalFact;
/**
 * This class overrides AbsractVisitor so that it can be used with relational Log4KR data types.
 * 
 * @author koecher
 *
 */
@SuppressWarnings("rawtypes")
public class Log4KRVisitor extends AbstractVisitor<Sort, Term, Constant, Variable, Predicate, RelationalConditional, Formula, AtomicConstraint>{
	
	////////////////////
	// Create Methods //
	////////////////////

	@Override
	public Sort createSort(String sort_name) {
		return new Sort(sort_name);
	}

	@Override
	public Constant createConstant(String constant_name, Sort sort) {
		return new Constant(constant_name, sort);
	}

	@Override
	public Predicate createPredicate(String predicate_name,
			Collection<Sort> arguments) {
		return new Predicate(predicate_name, arguments.toArray(new Sort[arguments.size()]));
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	protected RelationalConditional createFact(Formula consequence,
			Fraction probability, Formula constraint) {
		return new RelationalFact(consequence, probability, constraint);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	protected RelationalConditional createConditional(Formula consequence,
			Formula antecedence, Fraction probability,
			Formula constraint) {
		return new RelationalConditional(consequence, antecedence, probability, constraint);
	}

	@Override
	protected Formula createEqualityConstraint(Variable v, Term t) {
		return new EqualityConstraint(v, t);
	}

	@Override
	protected Formula createInequalityConstraint(Variable v, Term t) {
		return new InequalityConstraint(v, t);
	}

	@SuppressWarnings({ })
	@Override
	protected Formula not(Formula f) {
		return f.not();
	}

	@Override
	protected Formula<RelationalAtom> createAtom(Predicate predicate,
			Collection<Term> terms) {
		return new RelationalAtom(predicate, terms.toArray(new Term[terms.size()]));
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	protected Formula or(Formula f1, Formula f2) {
		return f1.or(f2);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	protected Formula and(Formula f1, Formula f2) {
		return f1.and(f2);
	}

	@Override
	protected Variable createVariable(String constant_name, Sort sort) {
		return new Variable(constant_name, sort);
	}

	@Override
	protected Sort getSortFromTermPosition(Predicate predicate, int termPosition) {
		return predicate.getArgumentSorts()[termPosition];
	}

}
