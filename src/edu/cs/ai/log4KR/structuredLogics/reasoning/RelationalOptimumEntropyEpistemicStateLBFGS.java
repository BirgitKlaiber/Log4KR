package edu.cs.ai.log4KR.structuredLogics.reasoning;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.relational.classicalLogic.grounding.GroundingOperator;
import edu.cs.ai.log4KR.relational.classicalLogic.semantics.RelationalPossibleWorld64BitRepresentationFactory;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;
import edu.cs.ai.log4KR.structuredLogics.RelationalSemantics;

//TODO add documentation
/**
 * An epistemic state that is defined by the principle of optimum entropy. 
 * Belief Changes are computed by L-BFGS.
 * 
 * @author NicoPotyka
 *
 * @param <I>
 */
public class RelationalOptimumEntropyEpistemicStateLBFGS extends OptimumEntropyEpistemicStateLBFGS<RelationalAtom> {

	
	public RelationalOptimumEntropyEpistemicStateLBFGS(RelationalSemantics semantics) {
		super(semantics);
		this.worldFactory = new RelationalPossibleWorld64BitRepresentationFactory();
	}

	
	
	
	@Override
	protected void extendKnowledgeBase(
			Collection<? extends Conditional<RelationalAtom>> newConditionals) {

		Collection<RelationalConditional> currentKB = (Collection<RelationalConditional>) this.knowledgeBase;
		Collection<RelationalConditional> newKB = (Collection<RelationalConditional>) newConditionals;
		currentKB.addAll(newKB);
		this.knowledgeBase = currentKB;
		
	}

	public GroundingOperator getGop() {
		return ((RelationalSemantics) semantics).getGop();
	}

}
