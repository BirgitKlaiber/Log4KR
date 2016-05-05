package edu.cs.ai.log4KR.structuredLogics.satisfiability;

import java.util.Collection;

import lpsolve.LpSolve;
import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * Test satisfiability by minimizing a relaxed linear program.
 * 
 * @author NicoPotyka
 *
 * @param <I>
 */
public class SatisfiabilityTestRelaxedLP<I extends Interpretable> implements SatisfiabilityTest<I> {

	protected StructuredSemantics<I> semantics;
	protected Interpretation<I>[] possibleWorlds;
	
	
	
	public SatisfiabilityTestRelaxedLP(Interpretation<I>[] possibleWorlds, StructuredSemantics<I> semantics) {
		
		this.semantics = semantics;
		this.possibleWorlds = possibleWorlds;
	}
	
	
	
	
	@Override
	public boolean isSatisfiable(Collection<? extends Conditional<I>> knowledgeBase) {

		ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
		semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, knowledgeBase);
		double[][] constraints= matBuilder.getMatrix();
		int noConstraints = constraints.length;
		int noWorlds = possibleWorlds.length;
		
		
		//set up optimization problem (LPSolve starts indexing at 1)
		boolean satisfiable = false;
		int i;
		
		try {

			//there is one variable for each world in dist and one variable 
			//that relaxes the normalization constraint
			int noVars = noWorlds + 1;
		    LpSolve solver = LpSolve.makeLp(0, noVars);
			double[] variableVector = new double[noVars + 1];

			
			//generate non-negativity constraint
			for(i=0; i<noVars; i++) {
				solver.setLowbo(i+1, 0);
			}
		    
		    solver.setMinim();
		    solver.setVerbose(0);
		    
		    /**********************************************************************
		     * turn row entry mode on
		     ********************************************************************** */
		    solver.setAddRowmode(true);
		    

			//first generate objective!
			//the objective is to minimize the relaxing constraint variables
			for(i=0 ; i<noWorlds; i++) {
				variableVector[i+1] = 0;
			}
			variableVector[i+1] = 1;
		    solver.setObjFn(variableVector);
	
		    
			//generate normalizing constraint sum(p)=1 for probabilities
			for(i=0 ; i<noVars; i++) {
				variableVector[i+1] = 1;
			}
			solver.addConstraint(variableVector, LpSolve.EQ, 1);
	
			
			//for each constraint a_k p = 0, generate LPSolve constraint
			variableVector[noWorlds+1] = 0;
			for(int k=0; k<constraints.length; k++) {
	
				for(i=0 ; i<noWorlds; i++) {
					
					variableVector[i+1] = constraints[k][i];
					
				}
				
				solver.addConstraint(variableVector, LpSolve.EQ, 0); 
				
			}

		    /**********************************************************************
		     * turn row entry mode off
		     ********************************************************************** */
		    solver.setAddRowmode(false);

		    
		    //set initial feasible basis
		    int[] basis = new int[noConstraints + 1 + 1]; //constraints + normalizing + LPSolve offset

		    for(i=1; i<basis.length-1; i++) {
		    	basis[i] = i;
		    }
		    basis[i] = noConstraints + 1;

		    solver.setBasis(basis, false);
		    
		    
		    solver.solve();
		    double min = solver.getObjective();
		    solver.deleteLp();
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
		return "SatisfiabilityTestRelaxedLP";
	}
}
