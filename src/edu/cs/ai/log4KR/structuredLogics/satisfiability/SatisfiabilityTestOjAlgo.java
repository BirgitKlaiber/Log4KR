package edu.cs.ai.log4KR.structuredLogics.satisfiability;

import java.util.Collection;

import org.ojalgo.constant.BigMath;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

public class SatisfiabilityTestOjAlgo<I extends Interpretable> implements  SatisfiabilityTest<I> {

	protected StructuredSemantics<I> semantics;
	protected Interpretation<I>[] possibleWorlds;
	
	
	
	public SatisfiabilityTestOjAlgo(Interpretation<I>[] possibleWorlds, StructuredSemantics<I> semantics) {
		this.semantics = semantics;
		this.possibleWorlds = possibleWorlds;
	}
	
	
	@Override
	public boolean isSatisfiable(Collection<? extends Conditional<I>> knowledgeBase) {

		boolean satisfiable = false;
		
		try {

			ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
			semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, knowledgeBase);
			double[][] constraints= matBuilder.getMatrix();
			int noWorlds = possibleWorlds.length;
			
			
			//set up optimization problem 
			int i;

			//there is one variable for each world in dist and one variable 
			//that relaxes the normalization constraint
			int noVars = noWorlds + 1;
			
			//create non-negative variables 
			Variable[] tmpVariables = new Variable[noVars];
			for(i=0; i<noVars; i++) {
				tmpVariables[i] = new Variable("w"+i).lower(BigMath.ZERO);
			}
			
			//create optimization model			
			ExpressionsBasedModel tmpModel = new ExpressionsBasedModel(tmpVariables);
			
			
			//the objective is to minimize the relaxing constraint variables
			Expression tmpExpr = tmpModel.addExpression("Objective");
			tmpExpr.setLinearFactor(noWorlds, BigMath.ONE);
			tmpExpr.weight(BigMath.ONE);
			
			
			//generate normalizing constraint sum(p)=1 for probabilities
			tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ONE);
			for(i=0; i<noVars; i++) {
				tmpExpr.setLinearFactor(i, BigMath.ONE);
			}
	
			
			//for each constraint a_k p = 0, generate relaxed constraint
			for(int k=0; k<constraints.length; k++) {
				
				tmpExpr = tmpModel.addExpression("constraint"+k).level(BigMath.ZERO);
				for(i=0 ; i<noWorlds; i++) {
					
					tmpExpr.setLinearFactor(i, constraints[k][i]);
					
				}
				
			}

			
		    //TODO set initial feasible basis - how in ojAlgo?    

			Result result = tmpModel.minimise();
		    double min = result.getValue();
		    satisfiable = min < 0.00000001;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return satisfiable;
	}
	
	@Override
	public String toString() {
		return "SatisfiabilityTestOjAlgo";
	}

}
