package edu.cs.ai.log4KR.structuredLogics.reasoning;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.propositional.classicalLogic.semantics.PropositionalPossibleWorld64BitRepresentationFactory;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.propositional.util.PropositionalUtils;
import edu.cs.ai.log4KR.structuredLogics.PropositionalSemantics;

//TODO extend documentation
/**
 * An epistemic state that is defined by the principle of optimum entropy. 
 * Belief Changes are computed by L-BFGS.
 * 
 * @author NicoPotyka
 *
 * @param <I>
 */
public class PropositionalOptimumEntropyEpistemicStateLBFGS extends OptimumEntropyEpistemicStateLBFGS<PropositionalVariable> {



	public PropositionalOptimumEntropyEpistemicStateLBFGS() {
		super(new PropositionalSemantics());
		this.worldFactory = new PropositionalPossibleWorld64BitRepresentationFactory();
	}
	
	
	


	@Override
	protected void extendKnowledgeBase(
			Collection<? extends Conditional<PropositionalVariable>> newConditionals) {

		Collection<Conditional<PropositionalVariable>> currentKB = (Collection<Conditional<PropositionalVariable>>) this.knowledgeBase;
		Collection<Conditional<PropositionalVariable>> newKB = (Collection<Conditional<PropositionalVariable>>) newConditionals;
		currentKB.addAll(newKB);
		this.knowledgeBase = currentKB;
		
	}


}
