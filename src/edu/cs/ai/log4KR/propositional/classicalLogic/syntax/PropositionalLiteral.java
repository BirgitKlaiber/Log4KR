package edu.cs.ai.log4KR.propositional.classicalLogic.syntax;

import edu.cs.ai.log4KR.logical.syntax.Literal;

public class PropositionalLiteral extends Literal<PropositionalVariable> {
	
	public PropositionalLiteral(BooleanVariable var) {
		super(new PropositionalAtom(var));
	}

	public PropositionalLiteral(BooleanVariable var, boolean positive) {
		super(new PropositionalAtom(var),positive);
	}
	
	public PropositionalLiteral(PropositionalVariable var, String value) {
		super(new PropositionalAtom(var,value));
	}
	
	public PropositionalLiteral(PropositionalVariable var, String value, boolean positive) {
		super(new PropositionalAtom(var,value),positive);
	}
	


	
}
