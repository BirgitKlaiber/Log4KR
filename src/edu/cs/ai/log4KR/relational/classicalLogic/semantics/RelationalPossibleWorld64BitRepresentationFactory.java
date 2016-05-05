package edu.cs.ai.log4KR.relational.classicalLogic.semantics;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorld64BitRepresentation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorld64BitRepresentation.AtomInformation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldFactory;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;

public class RelationalPossibleWorld64BitRepresentationFactory extends PossibleWorldFactory<RelationalAtom> {
	
	@Override
	protected Interpretation<RelationalAtom> createEmptyWorld(
			Collection<RelationalAtom> atoms) {
		
		return new RelationalPossibleWorld64BitRepresentation(new AtomInformation<RelationalAtom>(atoms), 0);
	}

	@Override
	protected Interpretation<RelationalAtom> extendWorld(
			Interpretation<RelationalAtom> partialWorld, RelationalAtom atom,
			int value) {


		RelationalPossibleWorld64BitRepresentation newWorld = new RelationalPossibleWorld64BitRepresentation((PossibleWorld64BitRepresentation<RelationalAtom>) partialWorld);
		newWorld.setValue(atom, value);
		return newWorld;
	}

}
