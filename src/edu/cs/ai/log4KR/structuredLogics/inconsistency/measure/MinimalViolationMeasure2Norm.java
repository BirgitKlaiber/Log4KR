package edu.cs.ai.log4KR.structuredLogics.inconsistency.measure;

import org.ojalgo.access.Access2D.Builder;
import org.ojalgo.constant.BigMath;
import org.ojalgo.matrix.BasicMatrix.Factory;
import org.ojalgo.matrix.PrimitiveMatrix;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * Minimal Violation Measure for Euclidean norm.
 * 
 * @author NicoPotyka
 *
 */
public class MinimalViolationMeasure2Norm<I extends Interpretable> extends InconsistencyMeasure<I> {

	protected Result result;
	
	
	
	public MinimalViolationMeasure2Norm(Interpretation<I>[] possibleWorlds, StructuredSemantics<I> semantics) {
		super(possibleWorlds, semantics);
	}
	
	
	
	@Override
	public double measureInconsistency(double[][] constraints, double[][] integrityConstraints) {

		this.constraints = constraints;
		this.integrityConstraints = integrityConstraints;
		
		try {
			
			int noWorlds = possibleWorlds.length;
			
			//set up optimization problem 
			
			//create non-negative variables 
			Variable[] tmpVariables = new Variable[noWorlds];
			for(int i=0; i<noWorlds; i++) {
				tmpVariables[i] = new Variable("p"+i).lower(BigMath.ZERO);
			}
			
			//create optimization model			
			ExpressionsBasedModel tmpModel = new ExpressionsBasedModel(tmpVariables);
			
			
			//Objective is x' Q x + C' x
			//Q = A' A for constraint matrix A, C' = 0 
			int m = constraints.length;
			int n = constraints[0].length;
			Factory<PrimitiveMatrix> tmpFactory = PrimitiveMatrix.FACTORY;
			Builder<PrimitiveMatrix> tmpBuilder = tmpFactory.getBuilder(m,n);
	        for (int i = 0; i<m; i++) {
	            for (int j = 0; j<n; j++) {
	                tmpBuilder.set(i, j, constraints[i][j]);
	            }
	        }
			PrimitiveMatrix tmpM = tmpBuilder.build();
			PrimitiveMatrix tmpQ = tmpM.transpose().multiplyRight(tmpM);
			
			Expression tmpExpr = tmpModel.addExpression("Objective");
			tmpModel.setMinimisation(true);
			for(int i=0; i<tmpQ.countRows(); i++) {
				for(int j=0; j<tmpQ.countColumns(); j++) {
					double q = tmpQ.get(i, j);
					if(q != 0) { //entries of Q can become arbitrary close to 0, therefore we have to check for equality (as opposed to d(q,0)>eps)
						tmpExpr.setQuadraticFactor(i, j, q);
					}
				}
			}
			tmpExpr.weight(BigMath.ONE);
			
			
			//generate normalizing constraint sum(p)=1 for probabilities
			tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ONE);
			for(int i=0; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, BigMath.ONE);
			}
			
			//generate integrity constraints
			if(integrityConstraints != null) {
				for(int k=0; k<integrityConstraints.length; k++) {
					
					tmpExpr = tmpModel.addExpression("integrityConstraint"+k).level(BigMath.ZERO);
					for(int i=0 ; i<noWorlds; i++) {
						tmpExpr.setLinearFactor(i, integrityConstraints[k][i]);
					}
					
				}
			}

			result = tmpModel.minimise();
			
		    return Math.sqrt(result.getValue());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
	}
	
	
	public Result getResult() {
		return result;
	}

	public double[] getViolationVector() {

		int m = constraints.length;
		long n = result.count();
		double[] violationVector = new double[m];

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				violationVector[i] += constraints[i][j] * result.get(j).doubleValue();
			}
		}
		
		return violationVector;
	}

	@Override
	public String toString() {
		return "MinVio2";
	}

}
