package edu.cs.ai.log4KR.structuredLogics.satisfiability;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;

/**
 * Test satisfiability of probabilistic conditional knowledge bases.
 * (Solve the PSAT problem)
 * 
 * @author NicoPotyka
 *
 */
public interface SatisfiabilityTest<I extends Interpretable> {
	
		/**
		 * Check whether conditional knowledge base is satisfiable.
		 * @param knowledgeBase
		 * @return
		 */
		public boolean isSatisfiable(Collection<? extends Conditional<I>> knowledgeBase);
}
