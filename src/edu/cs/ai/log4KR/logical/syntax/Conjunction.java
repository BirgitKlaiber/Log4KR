package edu.cs.ai.log4KR.logical.syntax;

import edu.cs.ai.log4KR.GlobalVariables;


/**
 * A conjunction of formulas.
 * @author NicoPotyka
 *
 */
public class Conjunction<I extends Interpretable> extends ComposedFormula<I> {

	
	
	public Conjunction(Formula<I> f1, Formula<I> f2) {
		super(f1, f2);
	}

	
	@Override
	public String toString() {
		return "("+f1.toString()+" "+GlobalVariables.CONJUNCTION+" "+f2.toString()+")";
	}

}
