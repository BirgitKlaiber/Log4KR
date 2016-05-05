package edu.cs.ai.log4KR.relational.util;

import java.util.Collection;
import java.util.HashSet;

import edu.cs.ai.log4KR.logical.syntax.Atom;
import edu.cs.ai.log4KR.relational.classicalLogic.grounding.GroundingOperator;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * Provides some utility functions.
 * 
 * @author NicoPotyka
 *
 */
public class RelationalUtils {

	
	
	public static Collection<RelationalAtom> getAtomsFromKnowledgeBase(Collection<RelationalConditional> knowledgeBase, 
			Collection<Constant> constants, GroundingOperator gop) {

		Collection<RelationalConditional> groundKnowledgeBase = gop.groundKnowledgeBase(knowledgeBase, constants);
		
		HashSet<Atom<RelationalAtom>> groundAtoms = new HashSet<Atom<RelationalAtom>>();
		for(RelationalConditional groundC: groundKnowledgeBase) {
			groundAtoms.addAll(groundC.getAtoms());
		}
		
		HashSet<RelationalAtom> atoms =new HashSet<RelationalAtom>();
		for(Atom<RelationalAtom> atom: groundAtoms) {
			atoms.add((RelationalAtom) atom);
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
	public static void decomposeKnowledgeBaseDeteterministicProbabilistic(Collection<RelationalConditional> kb, Collection<RelationalConditional> kbDet,
			Collection<RelationalConditional> kbProb) {
			
		for(RelationalConditional c: kb) {
				
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
