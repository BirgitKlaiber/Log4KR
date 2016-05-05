package edu.cs.ai.log4KR.relational.classicalLogic.semantics;

import java.util.Collection;
import java.util.HashMap;

import edu.cs.ai.log4KR.GlobalVariables;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldMapRepresentation;
import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;

public class RelationalPossibleWorldMapRepresentation extends PossibleWorldMapRepresentation<RelationalAtom> {


	
	protected RelationalPossibleWorldMapRepresentation(
			HashMap<RelationalAtom, Integer> interpretation,
			Collection<RelationalAtom> interpretables) {
		super(interpretation, interpretables);
	}

	protected RelationalPossibleWorldMapRepresentation(
			PossibleWorldMapRepresentation<RelationalAtom> partialWorld) {
		super(partialWorld);
	}
	
	
	

	@Override
	public boolean satisfies(Atom<RelationalAtom> atom) {
		
		//an unknown atom is interpreted as false
		return interpretation.get(atom) != null  &&
				interpretation.get(atom) == GlobalVariables.TRUE;
	}

	


}
