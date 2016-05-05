package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.types.Fraction;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.constraints.AtomicConstraint;


/**
 * This class represents a relational conditional.
 * 
 * @author koecher, NicoPotyka
 *
 */

public class RelationalConditional extends Conditional<RelationalAtom> {
	
	protected Formula<AtomicConstraint> constraint;
	
	

	public RelationalConditional(Formula<RelationalAtom> consequence, Formula<RelationalAtom> antecedence, Fraction probability, Formula<AtomicConstraint> constraint) {
		super(consequence,antecedence,probability);
		this.constraint = constraint;
	}

	public RelationalConditional(Formula<RelationalAtom> consequence, Formula<RelationalAtom> antecedence, Formula<AtomicConstraint> constraint) {
		super(consequence,antecedence);
		this.constraint = constraint;
	}
	
	public RelationalConditional(Formula<RelationalAtom> consequence, Formula<RelationalAtom> antecedence, Fraction probability) {
		super(consequence,antecedence,probability);
	}
	
	public RelationalConditional(Formula<RelationalAtom> consequence, Formula<RelationalAtom> antecedence) {
		super(consequence, antecedence);
	}
	
	

	public Formula<AtomicConstraint> getConstraint() {
		return constraint;
	}
	
	@Override
	public String toString() {
		if(constraint != null){
			return super.toString() + "<" + constraint + ">";
		}
		return super.toString();
	}
	
}