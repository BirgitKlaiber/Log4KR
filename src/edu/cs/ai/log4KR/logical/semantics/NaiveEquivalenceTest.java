package edu.cs.ai.log4KR.logical.semantics;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;

/**
 * Test equivalence naively by checking the complete truth table.
 * @author NicoPotyka
 *
 */
public class NaiveEquivalenceTest<I  extends Interpretable> implements EquivalenceTest<I> {

	private Interpretation<I>[] possibleWorlds;
	
	
	public NaiveEquivalenceTest(PossibleWorldFactory<I> worldFactory, Collection<I> atoms ) {
		
		this.possibleWorlds = worldFactory.createPossibleWorlds(atoms);
		
	}
	
	
	@Override
	public boolean isEquivalentTo(Formula<I> f1, Formula<I> f2) {

		for(Interpretation<I> world: possibleWorlds) {
			if(world.satisfies(f1) != world.satisfies(f2)) {
				return false;
			}
		}
		
		return true;
		
	}

}
