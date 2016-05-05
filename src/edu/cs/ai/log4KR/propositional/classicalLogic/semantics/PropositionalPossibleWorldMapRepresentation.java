package edu.cs.ai.log4KR.propositional.classicalLogic.semantics;

import java.util.Collection;
import java.util.HashMap;

import edu.cs.ai.log4KR.GlobalVariables;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldMapRepresentation;
import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.BooleanVariable;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalAtom;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;

public class PropositionalPossibleWorldMapRepresentation extends PossibleWorldMapRepresentation<PropositionalVariable> {

	
	
	protected PropositionalPossibleWorldMapRepresentation(
			HashMap<PropositionalVariable, Integer> interpretation,
			Collection<PropositionalVariable> interpretables) {
		super(interpretation, interpretables);
	}

	protected PropositionalPossibleWorldMapRepresentation(
			PossibleWorldMapRepresentation<PropositionalVariable> partialWorld) {
		super(partialWorld);
	}

	
	
	@Override
	public boolean satisfies(Atom<PropositionalVariable> atom) {
		
		//an unknown atom is interpreted as false
		if(atom.getInterpretable() instanceof BooleanVariable) {
			return interpretation.get(atom.getInterpretable()) != null && 
					interpretation.get(atom.getInterpretable()) == GlobalVariables.TRUE;
		}
		
		return interpretation.get(atom.getInterpretable()) !=null  &&
				interpretation.get(atom.getInterpretable()) == ((PropositionalAtom) atom).getValueIndex();
	}



}
