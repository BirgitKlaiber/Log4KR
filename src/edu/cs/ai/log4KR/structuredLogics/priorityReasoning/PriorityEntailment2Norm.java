package edu.cs.ai.log4KR.structuredLogics.priorityReasoning;

import java.util.Collection;

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
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * Priority entailment with euclidean norm.
 * 
 * @author NicoPotyka
 *
 */
public class PriorityEntailment2Norm<I extends Interpretable> extends AbstractPriorityEntailmentComponent<I> {

	//due to numerical problems, we have to replace the equality constraints c=0 with approximate constraints -eps <= c <= eps
	private double epsilon = 10E-5;
	
	private boolean relaxSetup;
	private boolean relaxInitialization;
	
	
	public PriorityEntailment2Norm(StructuredSemantics<I> semantics) {
		super(semantics);
		relaxSetup = false;
		relaxInitialization = true;
	}


	/**
	 * Initialize entailment component. 
	 * The priority knowledge base contains integrity constraints at index 0. For i>0,
	 * it contains the subset of priority i at index i.
	 * The priority knowledge base is supposed to be valid, that is, taking the integrity
	 * constraints IC and an arbitrary subset KBi, we assume that (IC union KBi) is consistent.
	 * 
	 * @param possibleWorlds
	 * @param priorityKnowledgeBase
	 */
	public void initialize(Interpretation<I>[] possibleWorlds, 
							Collection<? extends Conditional<I>>... priorityKnowledgeBase) {

		this.possibleWorlds = possibleWorlds;
		int noWorlds = possibleWorlds.length;
		int priorityLevels = priorityKnowledgeBase.length-1; //subtract 1 for integrity constraints
		
		//generate constraint matrices
		double constraintMatrices[][][] = new double[priorityKnowledgeBase.length][][];
		for(int i=0; i<priorityKnowledgeBase.length; i++) {
			ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
			semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, priorityKnowledgeBase[i]);
			constraintMatrices[i] = matBuilder.getMatrix();
		}
		
		//create non-negative variables 
		Variable[] variables1 = new Variable[noWorlds];
		for(int i=0; i<noWorlds; i++) {
			variables1[i] = new Variable("p"+i).lower(BigMath.ZERO);
		}
		//determine violation vectors for constraint matrices
		double[][] violationVector = new double[priorityKnowledgeBase.length][];
		
		for(int p=priorityKnowledgeBase.length-2; p>0; p--) {
						
			//set up optimization problem 
			
			//create optimization model			
			ExpressionsBasedModel tmpModel = new ExpressionsBasedModel(variables1);
			
			
			//Objective is x' Q x + C' x
			//Q = A' A for constraint matrix A, C' = 0 
			int m = constraintMatrices[p].length;
			int n = constraintMatrices[p][0].length;
			Factory<PrimitiveMatrix> tmpFactory = PrimitiveMatrix.FACTORY;
			Builder<PrimitiveMatrix> tmpBuilder = tmpFactory.getBuilder(m,n);
	        for (int i = 0; i<m; i++) {
	            for (int j = 0; j<n; j++) {
	                tmpBuilder.set(i, j, constraintMatrices[p][i][j]);
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
			for(int i=0; i<constraintMatrices[0].length; i++) {
				
				tmpExpr = tmpModel.addExpression("integrityConstraint"+i).level(BigMath.ZERO);
				for(int j=0 ; j<noWorlds; j++) {
					tmpExpr.setLinearFactor(j, constraintMatrices[0][i][j]);
				}
				
			}

			//generate consistency constraints for subset with highest priority 
			for(int i=0; i<constraintMatrices[priorityLevels].length; i++) {
				
				tmpExpr = tmpModel.addExpression("subset of level "+priorityLevels+" constraint "+i).level(BigMath.ZERO);
				for(int j=0 ; j<noWorlds; j++) {
					tmpExpr.setLinearFactor(j, constraintMatrices[priorityLevels][i][j]);
				}
				
			}
			
			//generate minimal violation constraints for all subsets with higher priority
			for(int k=priorityLevels-1; k>p; k--) {
				
				for(int i=0; i<constraintMatrices[k].length; i++) {

					if(relaxSetup) {
						
						tmpExpr = tmpModel.addExpression("subset of level "+k+" upper constraint "+i).upper(violationVector[k][i] + epsilon);
						for(int j=0 ; j<noWorlds; j++) {
							tmpExpr.setLinearFactor(j, constraintMatrices[k][i][j]);
						}

						tmpExpr = tmpModel.addExpression("subset of level "+k+" lower constraint "+i).lower(violationVector[k][i]-epsilon);
						for(int j=0 ; j<noWorlds; j++) {
							tmpExpr.setLinearFactor(j, constraintMatrices[k][i][j]);
						}
						
					}
					else {			
						
						tmpExpr = tmpModel.addExpression("subset of level "+k+" constraint "+i).level(violationVector[k][i]);
						for(int j=0 ; j<noWorlds; j++) {
							tmpExpr.setLinearFactor(j, constraintMatrices[k][i][j]);
						}

					}
					
				}
				
			}

			//optimize and store violation vector
			Result result = tmpModel.minimise();
			violationVector[p] = new double[m];

			for(int i=0; i<m; i++) {
				violationVector[p][i]  = 0;
				for(int j=0; j<n; j++) {
					violationVector[p][i] += constraintMatrices[p][i][j] * result.get(j).doubleValue();
				}
			}
			
		}
		
		//now set up the priority entailment problem
		int noVars = noWorlds + 1;
		
		//create non-negative variables 
		Variable[] tmpVariables = new Variable[noVars];
		for(int i=0; i<noWorlds; i++) {
			tmpVariables[i] = variables1[i];
		}
		tmpVariables[noWorlds] = new Variable("t").lower(BigMath.ZERO);
		
		
		//create optimization model			
		tmpModel = new ExpressionsBasedModel(tmpVariables);
		Expression tmpExpr;
		
		
		//generate integrity constraints 
		for(int i=0; i<constraintMatrices[0].length; i++) {
			
			tmpExpr = tmpModel.addExpression("integrityConstraint"+i).level(BigMath.ZERO);
			for(int j=0 ; j<noWorlds; j++) {
				tmpExpr.setLinearFactor(j, constraintMatrices[0][i][j]);
			}
			
		}

		//if knowledge base consists of more than integrity constraints
		if(priorityLevels > 0) {
			
			//generate consistency constraints for subset with highest priority
			for(int i=0; i<constraintMatrices[priorityLevels].length; i++) {
				
				tmpExpr = tmpModel.addExpression("subset of level "+priorityLevels+" constraint "+i).level(BigMath.ZERO);
				for(int j=0 ; j<noWorlds; j++) {
					tmpExpr.setLinearFactor(j, constraintMatrices[priorityLevels][i][j]);
				}
				
			}

			
			//generate minimal violation constraints for the remaining subsets
			for(int p=priorityLevels-1; p>0; p--) {
				
				for(int i=0; i<constraintMatrices[p].length; i++) {
					
					if(relaxInitialization) {

						tmpExpr = tmpModel.addExpression("subset of level "+p+" upper constraint "+i).upper(epsilon);
						for(int j=0 ; j<noWorlds; j++) {
							tmpExpr.setLinearFactor(j, constraintMatrices[p][i][j]);
						}
						tmpExpr.setLinearFactor(noWorlds, -violationVector[p][i]);

						tmpExpr = tmpModel.addExpression("subset of level "+p+" lower constraint "+i).lower(-epsilon);
						for(int j=0 ; j<noWorlds; j++) {
							tmpExpr.setLinearFactor(j, constraintMatrices[p][i][j]);
						}
						tmpExpr.setLinearFactor(noWorlds, -violationVector[p][i]);

					}
					else {

						tmpExpr = tmpModel.addExpression("subset of level "+p+" constraint "+i).level(BigMath.ZERO);
						for(int j=0 ; j<noWorlds; j++) {
							tmpExpr.setLinearFactor(j, constraintMatrices[p][i][j]);
						}
						tmpExpr.setLinearFactor(noWorlds, -violationVector[p][i]);
						
					}
					
				}
				
			}
		}
		
		//generate normalizing constraint sum(p) - y = 1 
		tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ZERO);
		for(int i=0; i<noWorlds; i++) {
			tmpExpr.setLinearFactor(i, BigMath.ONE);
		}
		tmpExpr.setLinearFactor(noWorlds, -1);

		
	}


	/**
	 * Set precision for optimization problems 
	 * (if epsilon is too small, query results will be empty intervals)
	 * 
	 * @param epsilon
	 */
	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
	
	
	/**
	 * To avoid numerical problems, sometimes priority constraints must be relaxed. 
	 * You should start by relaxing initialization only. 
	 * If there are still meaningless results, also relax setup.
	 * If you decide to relax setup, initialization is also relaxed, no matter what
	 * your choice is (relaxing only setup will yield meaningless results).
	 * @param setup
	 * @param initialization
	 */
	public void relaxConstraints(boolean setup, boolean initialization) {
		
		if(setup) {
			relaxSetup = relaxInitialization = true;
		}
		else {
			relaxSetup = setup;
			relaxInitialization = initialization;
		}
	}
	
	@Override
	public String toString() {
		return "Strict Priority Entailment with Euclidean Norm";
	}
}
