package edu.cs.ai.log4KR.propositional.util;

import java.util.Collection;
import java.util.HashSet;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * Provides some utility functions.
 * 
 * @author NicoPotyka
 *
 */
public class PropositionalUtils {

	public static Collection<PropositionalVariable> getAtomsFromKnowledgeBase(Collection<Conditional<PropositionalVariable>> knowledgeBase) {

		Collection<PropositionalVariable> atoms = new HashSet<PropositionalVariable>();
		for(Conditional<PropositionalVariable> c: knowledgeBase) {
			for(Atom<PropositionalVariable> a: c.getAtoms()) {
				atoms.add(a.getInterpretable());
			}
		}
		
		return atoms;
		
	}
	
	
	/**
	 * Takes a knowledge base and decomposes it into its deterministic and probabilistic part.
	 * Usually kb will be a knowledge base and kbDet and kbProb are empty collections that take
	 * the deterministic and probabilistic part, respectively.
	 * @param kb knowledge base
	 * @param kbDet takes conditionals of deterministic part
	 * @param kbProb takes conditionals of probabilistic part
	 */
	public static void decomposeKnowledgeBaseDeteterministicProbabilistic(Collection<Conditional<PropositionalVariable>> kb, Collection<Conditional<PropositionalVariable>> kbDet,
			Collection<Conditional<PropositionalVariable>> kbProb) {
			
		for(Conditional<PropositionalVariable> c: kb) {
				
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
