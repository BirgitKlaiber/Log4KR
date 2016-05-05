package edu.cs.ai.log4KR.propositional.classicalLogic.semantics;

import java.util.Collection;
import java.util.HashMap;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldFactory;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldMapRepresentation;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;

public class PropositionalPossibleWorldMapRepresentationFactory extends PossibleWorldFactory<PropositionalVariable> {

	@Override
	protected Interpretation<PropositionalVariable> createEmptyWorld(
			Collection<PropositionalVariable> atoms) {

		return new PropositionalPossibleWorldMapRepresentation(new HashMap<PropositionalVariable, Integer>(),atoms);
	}

	@Override
	protected Interpretation<PropositionalVariable> extendWorld(
			Interpretation<PropositionalVariable> partialWorld,
			PropositionalVariable atom, int value) {

		PropositionalPossibleWorldMapRepresentation newWorld = new PropositionalPossibleWorldMapRepresentation((PossibleWorldMapRepresentation<PropositionalVariable>) partialWorld);
		newWorld.getInterpretation().put(atom, value);
		return newWorld;
	}
	
}
