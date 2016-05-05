package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Tautology;
import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.AtomicConstraint;


/**
 * A Fact is a Conditional with tautological antecedence.
 * @see RelationalConditional
 * @author koecher, NicoPotyka
 *
 */
public class RelationalFact extends RelationalConditional {

	public RelationalFact(Formula<RelationalAtom> consequence, Fraction probability, Formula<AtomicConstraint> constraint) {
		super(consequence,Tautology.create(),probability,constraint);
	}
	
	public RelationalFact(Formula<RelationalAtom> consequence, Formula<AtomicConstraint> constraint) {
		super(consequence,Tautology.create(),constraint);
	}
	
	public RelationalFact(Formula<RelationalAtom> consequence, Fraction probability) {
		super(consequence,Tautology.create(),probability);
	}
	
	public RelationalFact(Formula<RelationalAtom> consequence, double probability) {
		super(consequence,Tautology.create(),new Fraction(probability));
	}
	
	public RelationalFact(Formula<RelationalAtom> consequence, String probability) {
		super(consequence,Tautology.create(),new Fraction(probability));
	}
	
	public RelationalFact(Formula<RelationalAtom> consequence) {
		super(consequence,Tautology.create());
	}
	
	@Override
	protected String getConditionalString() {
		return ("(" + consequence + ")");
	}

}
