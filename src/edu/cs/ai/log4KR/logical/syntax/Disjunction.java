package edu.cs.ai.log4KR.logical.syntax;

import edu.cs.ai.log4KR.GlobalVariables;


/**
 * A disjunction of formulas.
 * @author NicoPotyka
 *
 */
public class Disjunction<I extends Interpretable> extends ComposedFormula<I> {

	
	public Disjunction(Formula<I> f1, Formula<I> f2) {
		super(f1, f2);
	}

	
	@Override
	public String toString() {
		return "("+f1.toString()+" "+GlobalVariables.DISJUNCTION+" "+f2.toString()+")";
	}

}
