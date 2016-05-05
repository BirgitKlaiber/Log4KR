package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.meCoreReader;

import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.AbstractVisitor;
import edu.cs.ai.mecore.logic.Conditional;
import edu.cs.ai.mecore.logic.Proposition;
import edu.cs.ai.mecore.logic.Term;
import edu.cs.ai.mecore.logic.Variable;
/**
 * 
 * @author koecher
 *
 */
public class MeCoreVisitor extends AbstractVisitor<Variable,Proposition,Conditional>{

	@Override
	protected Variable createMultivaluedVar(String varName,
			String... varValues) {
		return new Variable(varName, varValues);
	}

	@Override
	protected Proposition or(Proposition formula1, Proposition formula2) {
		return formula1.or(formula2);
	}

	@Override
	protected Proposition not(Proposition formula) {
		return formula.neg();
	}

	@Override
	protected Proposition and(Proposition formula1, Proposition formula2) {
		return formula1.and(formula2);
	}

	@Override
	protected Variable createBinaryVar(String varName) {
		return new Variable(varName, Term.True.toString(), Term.False.toString());
	}

	@Override
	protected Proposition allocateTrueToVariable(Variable variable) {
		return new Term(variable, Term.True.toString());
	}

	@Override
	protected Proposition allocateValueToVariable(Variable variable,
			String value) {
		return new Term(variable, value);
	}

	@Override
	protected Conditional createFactWithProbability(Proposition formula,
			Fraction probability) {
		return new Conditional(formula, probability.toFloatingPoint());
	}

	@Override
	protected Conditional createFactWithoutProbability(Proposition formula) {
		return new Conditional(formula);
	}

	@Override
	protected Conditional createConditionalWithoutProbability(
			Proposition consequence, Proposition antecedence) {
		return new Conditional(consequence, antecedence);
	}

	@Override
	protected Conditional createConditionalWithProbability(Proposition consequence,
			Proposition antecedence, Fraction probability) {
		return new Conditional(consequence, antecedence, probability.toFloatingPoint());
	}
	
}