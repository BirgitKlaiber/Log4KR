package edu.cs.ai.log4KR.relational.classicalLogic.semantics;

import edu.cs.ai.log4KR.GlobalVariables;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorld64BitRepresentation;
import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;

public class RelationalPossibleWorld64BitRepresentation extends PossibleWorld64BitRepresentation<RelationalAtom> {

	
	public RelationalPossibleWorld64BitRepresentation(AtomInformation<RelationalAtom> atomInfo, long interpretation) {
		super(atomInfo, interpretation, null);
	}
	public RelationalPossibleWorld64BitRepresentation(PossibleWorld64BitRepresentation<RelationalAtom> other) {
		super(other);
	}
	
	
	

	@Override
	public boolean satisfies(Atom<RelationalAtom> atom) {

		return getValue(atom.getInterpretable()) == GlobalVariables.TRUE;
		
	}



}
