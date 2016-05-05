package edu.cs.ai.log4KR.logical;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;

/**
 * General utility classes.
 * 
 * @author NicoPotyka
 *
 */
public class LogicalUtils {

	
	/**
	 * Takes a knowledge base and decomposes it into its deterministic and probabilistic part.
	 * Usually kb will be a knowledge base and kbDet and kbProb are empty collections that take
	 * the deterministic and probabilistic part, respectively.
	 * @param kb knowledge base
	 * @param kbDet takes conditionals of deterministic part
	 * @param kbProb takes conditionals of probabilistic part
	 */
	public static <I extends Interpretable> void decomposeKnowledgeBaseDeteterministicProbabilistic(Collection<Conditional<I>> kb, Collection<Conditional<I>> kbDet,
			Collection<Conditional<I>> kbProb) {
			
		for(Conditional<I> c: kb) {
				
				double p = c.getProbability().toFloatingPoint();
				
				if(p==0 || p==1) {
					kbDet.add(c);
				}
				else{
					kbProb.add(c);
				}
			}
		
	}
}
