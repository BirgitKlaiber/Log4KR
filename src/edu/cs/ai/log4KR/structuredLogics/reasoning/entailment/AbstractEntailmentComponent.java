package edu.cs.ai.log4KR.structuredLogics.reasoning.entailment;

import java.util.Collection;

import org.ojalgo.constant.BigMath;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.math.types.Interval;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * Abstract superclass for entailment components.
 * You have to overwrite initialize to initialize the optimization model appropriately.
 * 
 * @author NicoPotyka
 *
 * @param <I>
 */
public abstract class AbstractEntailmentComponent<I extends Interpretable> {

	protected StructuredSemantics<I> semantics;
	protected double[][] constraintMatrix;
	protected Interpretation<I>[] possibleWorlds;
	
	protected ExpressionsBasedModel tmpModel;
	protected boolean scepticalEntailment;  //switch between sceptical and credulous entailment
	
	public AbstractEntailmentComponent(StructuredSemantics<I> semantics) {
		this.semantics = semantics;
		this.scepticalEntailment = true;
	}
	
	
	/**
	 * 
	 * @param possibleWorlds
	 * @param knowledgeBase
	 */
	public void initialize(Interpretation<I>[] possibleWorlds, Collection<? extends Conditional<I>> knowledgeBase) {
		
		if(possibleWorlds==null || knowledgeBase==null) {
			throw new IllegalArgumentException("You have to provide a set of possible worlds and a knowledge base to initialize epistemic state.");
		}
		
		this.possibleWorlds = possibleWorlds;
		ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
		semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, knowledgeBase);
		this.constraintMatrix = matBuilder.getMatrix();
		
	}
	
	
	
	
	public Interval queryProbability(Conditional<I> cond) {
		
		Interval result = null;

		try {
			
			int noWorlds = possibleWorlds.length;
			
			//for each dimension (ground instance) of the query conditional, 
			//generate query normalization constraint and compute upper and lower bounds
			int[][] verifyingMat = semantics.getVerifyingMatrix(possibleWorlds, cond);
			int[][] falsifyingMat = semantics.getFalsifyingMatrix(possibleWorlds, cond);
			
			Expression queryNormalizationExpr = tmpModel.addExpression("Query-Normalization").level(BigMath.ONE);
			Expression objExpr = tmpModel.addExpression("Objective");
			objExpr.weight(BigMath.ONE);
			
			//for each dimension
			for(int k=0; k<verifyingMat.length; k++) {
				
				//query normalization
				if(k>0) {
					//reset query normalization constraint
					for(int i=0; i<noWorlds; i++) {
						queryNormalizationExpr.setLinearFactor(i, BigMath.ZERO);
					}
				}
				for(int i=0; i<verifyingMat[k].length; i++) {
					queryNormalizationExpr.setLinearFactor(i, verifyingMat[k][i]+falsifyingMat[k][i]);
				}
				
				//objective
				if(k>0) {
					//reset objective
					for(int i=0; i<noWorlds; i++) {
						objExpr.setLinearFactor(i, BigMath.ZERO);
					}
				}
				for(int i=0; i<verifyingMat[k].length; i++) {
					objExpr.setLinearFactor(i, verifyingMat[k][i]);
				}

				Result lower, upper;
				
				lower = tmpModel.minimise();
				if(!lower.getState().isFeasible()) {
					//if problem is infeasible, there is no need to compute bounds
					result = new Interval(1, 0);
					
				}
				else {
					upper = tmpModel.maximise();
					
					if(k==0) {
						result = new Interval(lower.getValue(), upper.getValue());
					}
					else {//there are several dimensions
						if(scepticalEntailment) {
							//intersect the resulting intervals to get the tightest answer
							Interval newResult = new Interval(lower.getValue(), upper.getValue());
							result.intersect(newResult);
						}
						else {
							//combine the resulting intervals
							Interval newResult = new Interval(lower.getValue(), upper.getValue());
							result.union(newResult);
							
						}
					}
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return result;
	}
	
	public void setScepticalEntailment() {
		this.scepticalEntailment = true;
	}
	public void setCredulousEntailment() {
		this.scepticalEntailment = false;
	}
	
}
