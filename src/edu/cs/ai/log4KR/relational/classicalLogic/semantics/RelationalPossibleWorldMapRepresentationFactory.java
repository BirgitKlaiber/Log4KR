package edu.cs.ai.log4KR.relational.classicalLogic.semantics;

import java.util.Collection;
import java.util.HashMap;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldFactory;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldMapRepresentation;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;

public class RelationalPossibleWorldMapRepresentationFactory extends PossibleWorldFactory<RelationalAtom> {

	@Override
	protected Interpretation<RelationalAtom> createEmptyWorld(
			Collection<RelationalAtom> atoms) {

		return new RelationalPossibleWorldMapRepresentation(new HashMap<RelationalAtom, Integer>(),atoms);
	}

	@Override
	protected Interpretation<RelationalAtom> extendWorld(
			Interpretation<RelationalAtom> partialWorld, RelationalAtom atom,
			int value) {
		
		RelationalPossibleWorldMapRepresentation newWorld = new RelationalPossibleWorldMapRepresentation((PossibleWorldMapRepresentation<RelationalAtom>) partialWorld);
		newWorld.getInterpretation().put(atom, value);
		return newWorld;
	}
	
}
