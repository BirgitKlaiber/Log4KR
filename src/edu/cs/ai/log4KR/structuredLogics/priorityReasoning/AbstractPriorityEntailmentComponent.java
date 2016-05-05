package edu.cs.ai.log4KR.structuredLogics.priorityReasoning;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;
import edu.cs.ai.log4KR.structuredLogics.inconsistency.reasoning.AbstractGeneralizedEntailmentComponent;

public abstract class AbstractPriorityEntailmentComponent<I extends Interpretable> extends AbstractGeneralizedEntailmentComponent<I>  {

	public AbstractPriorityEntailmentComponent(StructuredSemantics<I> semantics) {
		super(semantics);
	}
	

	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(Interpretation<I>[] possibleWorlds, Collection<? extends Conditional<I>> knowledgeBase) {

		Collection[] kbArray = new Collection[1];
		kbArray[0] = knowledgeBase;
		initialize(possibleWorlds, kbArray);
		
	}
	
	public abstract void initialize(Interpretation<I>[] possibleWorlds,
			Collection<? extends Conditional<I>>... priorityKnowledgeBase);
	
	
}
