package edu.cs.ai.log4KR.logical.semantics;

import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;

/**
 * Use implementations of this interface to test equivalence of formulas.
 * (equals does not check equivalence for performance reasons)
 * @author NicoPotyka
 *
 */
public interface EquivalenceTest<I extends Interpretable> {

	public boolean isEquivalentTo(Formula<I> f1, Formula<I> f2); 
	
}
