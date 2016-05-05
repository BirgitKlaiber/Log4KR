package edu.cs.ai.log4KR.structuredLogics.inconsistency.measure;

import org.ojalgo.constant.BigMath;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * Minimal Violation Measure for Manhattan norm.
 * 
 * @author NicoPotyka
 *
 */
public class MinimalViolationMeasure1Norm<I extends Interpretable> extends InconsistencyMeasure<I> {


	
	public MinimalViolationMeasure1Norm(Interpretation<I>[] possibleWorlds, StructuredSemantics<I> semantics) {
		super(possibleWorlds, semantics);
	}
	
	
	
	@Override
	public double measureInconsistency(double[][] constraints, double[][] integrityConstraints) {

		this.constraints = constraints;
		this.integrityConstraints = integrityConstraints;
		
		try {
			
			int noWorlds = possibleWorlds.length;
			int noConstraints = constraints.length;
			
			//set up optimization problem 

			//there is one variable for each world in dist and one variable 
			//for each constraint
			int noVars = noWorlds + noConstraints;
			
			//create non-negative variables 
			Variable[] tmpVariables = new Variable[noVars];
			for(int i=0; i<noWorlds; i++) {
				tmpVariables[i] = new Variable("p"+i).lower(BigMath.ZERO);
			}
			for(int i=0; i<noConstraints; i++) {
				tmpVariables[noWorlds+i] = new Variable("y"+i).lower(BigMath.ZERO);
			}
			
			//create optimization model			
			ExpressionsBasedModel tmpModel = new ExpressionsBasedModel(tmpVariables);
			
			
			//the objective is to minimize the relaxing constraint variables
			Expression tmpExpr = tmpModel.addExpression("Objective");
			for(int i=noWorlds; i<noVars; i++) {
				tmpExpr.setLinearFactor(i, BigMath.ONE);
			}
			tmpExpr.weight(BigMath.ONE);
			
			
			//generate normalizing constraint sum(p)=1 for probabilities
			tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ONE);
			for(int i=0; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, BigMath.ONE);
			}
	
			
			//for each constraint a_k p = 0, generate two relaxed constraint
			for(int k=0; k<noConstraints; k++) {
				
				tmpExpr = tmpModel.addExpression("lowerConstraint"+k).lower(BigMath.ZERO);
				for(int i=0 ; i<noWorlds; i++) {
					tmpExpr.setLinearFactor(i, constraints[k][i]);
				}
				tmpExpr.setLinearFactor(noWorlds+k, 1);

				tmpExpr = tmpModel.addExpression("upperConstraint"+k).upper(BigMath.ZERO);
				for(int i=0 ; i<noWorlds; i++) {
					tmpExpr.setLinearFactor(i, constraints[k][i]);
				}
				tmpExpr.setLinearFactor(noWorlds+k, -1);
				
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

			Result result = tmpModel.minimise();
		    return result.getValue();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return -1;
	}
	
	
	@Override
	public String toString() {
		return "MinVio1";
	}







}
