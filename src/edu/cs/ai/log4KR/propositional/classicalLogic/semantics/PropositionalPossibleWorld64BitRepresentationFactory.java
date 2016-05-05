package edu.cs.ai.log4KR.propositional.classicalLogic.semantics;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorld64BitRepresentation.AtomInformation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldFactory;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;

public class PropositionalPossibleWorld64BitRepresentationFactory extends PossibleWorldFactory<PropositionalVariable> {

	@Override
	protected Interpretation<PropositionalVariable> createEmptyWorld(
			Collection<PropositionalVariable> atoms) {
		return new PropositionalPossibleWorld64BitRepresentation(new AtomInformation<PropositionalVariable>(atoms), 0);
	}

	@Override
	protected Interpretation<PropositionalVariable> extendWorld(
			Interpretation<PropositionalVariable> partialWorld,
			PropositionalVariable atom, int value) {

		PropositionalPossibleWorld64BitRepresentation newWorld = new PropositionalPossibleWorld64BitRepresentation((PropositionalPossibleWorld64BitRepresentation)partialWorld);
		newWorld.setValue(atom, value);
		
		return  newWorld;
	}

}
