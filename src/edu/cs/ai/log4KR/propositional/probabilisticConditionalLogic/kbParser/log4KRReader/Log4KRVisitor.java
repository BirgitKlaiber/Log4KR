package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Fact;
import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.BooleanVariable;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalAtom;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.AbstractVisitor;
/**
 * 
 * @author koecher, NicoPotyka
 *
 */
public class Log4KRVisitor extends AbstractVisitor<PropositionalVariable,Formula<PropositionalVariable>,Conditional<PropositionalVariable>>{

	@Override
	protected PropositionalVariable createMultivaluedVar(String varName,
			String... varValues) {
		return new PropositionalVariable(varName, varValues);
	}

	@Override
	protected Formula<PropositionalVariable> or(Formula<PropositionalVariable> formula1, Formula<PropositionalVariable> formula2) {
		return formula1.or(formula2);
	}

	@Override
	protected Formula<PropositionalVariable> not(Formula<PropositionalVariable> formula) {
		return formula.not();
	}

	@Override
	protected Formula<PropositionalVariable> and(Formula<PropositionalVariable> formula1, Formula<PropositionalVariable> formula2) {
		return formula1.and(formula2);
	}

	@Override
	protected PropositionalVariable createBinaryVar(String varName) {
		return new BooleanVariable(varName);
	}

	@Override
	protected Formula<PropositionalVariable> allocateTrueToVariable(PropositionalVariable variable) {
		return (BooleanVariable) variable;
	}

	@Override
	protected Formula<PropositionalVariable> allocateValueToVariable(PropositionalVariable variable,
			String value) {
		return new PropositionalAtom(variable, value);
	}

	@Override
	protected Conditional<PropositionalVariable> createFactWithProbability(Formula<PropositionalVariable> formula,
			Fraction probability) {
		return new Fact<PropositionalVariable>(formula, probability);
	}

	@Override
	protected Conditional<PropositionalVariable> createFactWithoutProbability(Formula<PropositionalVariable> formula) {
		return new Fact<PropositionalVariable>(formula);
	}

	@Override
	protected Conditional<PropositionalVariable> createConditionalWithoutProbability(
			Formula<PropositionalVariable> consequence, Formula<PropositionalVariable> antecedence) {
		return new Conditional<PropositionalVariable>(consequence, antecedence);
	}

	@Override
	protected Conditional<PropositionalVariable> createConditionalWithProbability(Formula<PropositionalVariable> consequence,
			Formula<PropositionalVariable> antecedence, Fraction probability) {
		return new Conditional<PropositionalVariable>(consequence, antecedence, probability);
	}
	
}