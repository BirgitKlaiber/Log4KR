package edu.cs.ai.log4KR.propositional.classicalLogic.semantics;

import edu.cs.ai.log4KR.GlobalVariables;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorld64BitRepresentation;
import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.BooleanVariable;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalAtom;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;

public class PropositionalPossibleWorld64BitRepresentation extends PossibleWorld64BitRepresentation<PropositionalVariable> {

	
	public PropositionalPossibleWorld64BitRepresentation(AtomInformation<PropositionalVariable> atomInfo, long interpretation) {
		super(atomInfo, interpretation, null);
	}
	public PropositionalPossibleWorld64BitRepresentation(PossibleWorld64BitRepresentation<PropositionalVariable> other) {
		super(other);
	}
	
	
	

	@Override
	public boolean satisfies(Atom<PropositionalVariable> atom) {
		
		if(atom.getInterpretable() instanceof BooleanVariable) {
			return getValue(atom.getInterpretable()) == GlobalVariables.TRUE;
		}
		
		return getValue(atom.getInterpretable())  == ((PropositionalAtom) atom).getValueIndex();
	}



}
