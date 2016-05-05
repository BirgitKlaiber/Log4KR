package edu.cs.ai.log4KR.relational.classicalLogic.grounding;

import java.util.Collection;

import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * Interface for grounding operators.
 * 
 * @author NicoPotyka
 *
 */
public interface GroundingOperator {

	/**
	 * Generate all ground instances over a set of predicates and constants.
	 * @param atoms
	 * @param consts
	 * @return
	 */
	public Collection<RelationalAtom> groundPredicates(Collection<Predicate> predicates, Collection<Constant> consts);
	
	/**
	 * Generate all ground instances over a knowledge base and a set of constants.
	 * @param atoms
	 * @param consts
	 * @return
	 */
	public Collection<RelationalConditional> groundKnowledgeBase(Collection<RelationalConditional> conditionals, Collection<Constant> consts);
	
	public Collection<RelationalConditional> groundConditional(RelationalConditional cond, Collection<Constant> consts);
}
