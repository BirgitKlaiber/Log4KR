package edu.cs.ai.log4KR.structuredLogics;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.AbstractMatrixBuilder;


/**
 * A linear conditional semantics transforms conditionals into linear constraints f(p)=0 
 * over probability vectors p. Due to its linearity f(p) can be written as a*p for a row vector a. 
 * For a set of worlds and a conditional knowledge base R the function getConstraints determines 
 * a matrix A consisting of the corresponding row vectors, i.e., a probability vector p satisfies R 
 * iff A*p=0 holds. 
 * @author NicoPotyka
 *
 */
public interface StructuredSemantics<I extends Interpretable> {

	public void initializeConstraintMatrix(AbstractMatrixBuilder matBuilder, Interpretation<I>[] worlds, 
			Collection<? extends Conditional<I>> knowledgeBase);

	public int[][] getVerifyingMatrix(Interpretation<I>[] worlds, Conditional<I> c);
	public int[][] getFalsifyingMatrix(Interpretation<I>[] worlds, Conditional<I> c);
	
}
