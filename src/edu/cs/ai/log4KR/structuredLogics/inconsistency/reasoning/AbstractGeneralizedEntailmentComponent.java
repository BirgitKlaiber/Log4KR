package edu.cs.ai.log4KR.structuredLogics.inconsistency.reasoning;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;
import edu.cs.ai.log4KR.structuredLogics.reasoning.entailment.AbstractEntailmentComponent;

/**
 * Abstract generalized entailment component.
 * 
 * @author NicoPotyka
 *
 */
public class AbstractGeneralizedEntailmentComponent<I extends Interpretable> extends AbstractEntailmentComponent<I> {


	protected double[][] integrityConstraintMatrix;
	
	
	public AbstractGeneralizedEntailmentComponent(StructuredSemantics<I> semantics) {
		super(semantics);
	}
	
	
	public void initialize(Interpretation<I>[] possibleWorlds, 
			Collection<? extends Conditional<I>> knowledgeBase) {
		initialize(possibleWorlds, knowledgeBase, null);
	}
	
	
	public void initialize(Interpretation<I>[] possibleWorlds, 
							Collection<? extends Conditional<I>> knowledgeBase,
							Collection<? extends Conditional<I>> integrityConstraints		) {
		
		super.initialize(possibleWorlds, knowledgeBase);
		
		if(integrityConstraints != null) {
			ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
			semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, integrityConstraints);
			this.integrityConstraintMatrix = matBuilder.getMatrix();
		}
		
	}
	
	
}
