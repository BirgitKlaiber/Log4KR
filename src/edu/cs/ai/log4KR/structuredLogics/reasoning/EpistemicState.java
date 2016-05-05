package edu.cs.ai.log4KR.structuredLogics.reasoning;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Fact;

/**
 * An EpistemicState represents the belief state of an agent. Internally 
 * it stores a probability distribution over possible worlds of the problem domain.
 * The possible worlds are generated over a set of interpretable objects like
 * propositional variables or relational ground atoms. 
 * 
 * An EpistemicState has to be initialized with an array of possible worlds 
 * (the order determines the order of the corresponding probability vector)
 * and a knowledge base.
 * 
 * @author NicoPotyka
 *
 */
public interface EpistemicState<I extends Interpretable> {
	
	public void initialize(Interpretation<I>[] possibleWorlds, Collection<? extends Conditional<I>> knowledgeBase);

	
	public void revise(Collection<? extends Conditional<I>> knowledgeBase);
	public void update(Collection<? extends Conditional<I>> knowledgeBase);
	
	
	public double queryProbability(Formula<I> f);
	public double queryConditionalProbability(Formula<I> f, Formula<I> condition);
	public double query(Conditional<I> c);
	public double query(Fact<I> f);
	
	
}
