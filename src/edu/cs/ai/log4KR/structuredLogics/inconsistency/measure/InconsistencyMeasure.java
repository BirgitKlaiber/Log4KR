package edu.cs.ai.log4KR.structuredLogics.inconsistency.measure;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * An inconsistency measure takes a knowledge base and computes a non-negative
 * value that is meant to represent the degree of inconsistency of a knowledge base.
 * 
 * @author NicoPotyka
 */
public abstract class InconsistencyMeasure<I extends Interpretable> {


	protected StructuredSemantics<I> semantics;
	protected Interpretation<I>[] possibleWorlds;
	protected double[][] constraints;
	protected double[][] integrityConstraints;

	
	public InconsistencyMeasure(Interpretation<I>[] possibleWorlds, StructuredSemantics<I> semantics) {
		this.possibleWorlds = possibleWorlds;
		this.semantics = semantics;
	}
	
	
	
	
	public double measureInconsistency(Collection<? extends Conditional<I>> knowledgeBase) {

		return measureInconsistency(knowledgeBase,null);
		
	}
	
	public double measureInconsistency(Collection<? extends Conditional<I>> knowledgeBase, Collection<? extends Conditional<I>> integrityConstraints) {

		ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder(); 
		semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, knowledgeBase);
		this.constraints = matBuilder.getMatrix();
		this.integrityConstraints = null;
		if(integrityConstraints != null) {
			semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, integrityConstraints);
			this.integrityConstraints = matBuilder.getMatrix();
		}
		return measureInconsistency(constraints,this.integrityConstraints);
		
	}
	
	
	
	public abstract double measureInconsistency(double[][] constraints, double[][] integrityConstraints);
	
}
