package edu.cs.ai.log4KR.logical.syntax;

import edu.cs.ai.log4KR.GlobalVariables;


/**
 * An implication of formulas.
 * @author NicoPotyka
 *
 */
public class Implication<I extends Interpretable> extends ComposedFormula<I> {

	
	
	public Implication(Formula<I> f1, Formula<I> f2) {
		super(f1, f2);
	}
	

	@Override
	public String toString() {
		return "("+f1.toString()+" "+GlobalVariables.IMPLICATION+" "+f2.toString()+")";
	}

}
