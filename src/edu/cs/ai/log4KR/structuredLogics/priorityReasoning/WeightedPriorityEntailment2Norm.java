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
 * Weighted Priority entailment with euclidean norm.
 * 
 * @author NicoPotyka
 *
 */
public class WeightedPriorityEntailment2Norm<I extends Interpretable> extends AbstractPriorityEntailmentComponent<I> {

	
	private WeightingFunction wf;
	
	
	
	public WeightedPriorityEntailment2Norm(StructuredSemantics<I> semantics, WeightingFunction wf) {
		super(semantics);
		this.wf = wf;
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
		
		//generate constraint matrices
		double constraintMatrices[][][] = new double[priorityKnowledgeBase.length][][];
		for(int i=0; i<priorityKnowledgeBase.length; i++) {
			ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
			semantics.initializeConstraintMatrix(matBuilder, possibleWorlds, priorityKnowledgeBase[i]);
			constraintMatrices[i] = matBuilder.getMatrix();
		}
		
		//set up optimization problem(s)
		Variable[] tmpVariables;
		Expression tmpExpr;
		int ix;
		int n = noWorlds;
		
		
		//if knowledge base consists of more than integrity constraints, determine violation vector
		double[] violationVector = null;
		
		if(priorityKnowledgeBase.length > 1) {	
			
			//create non-negative variables 
			tmpVariables = new Variable[noWorlds];
			for(int i=0; i<noWorlds; i++) {
				tmpVariables[i] = new Variable("p"+i).lower(BigMath.ZERO);
			}
			
			//create optimization model			
			tmpModel = new ExpressionsBasedModel(tmpVariables);
			
			
			//Objective is x' Q x + C' x
			//Q = A' A for constraint matrix A, C' = 0 
			int m = 0;
			for(int i=1; i<constraintMatrices.length; i++) {
				m += constraintMatrices[i].length;
			}
			Factory<PrimitiveMatrix> tmpFactory = PrimitiveMatrix.FACTORY;
			Builder<PrimitiveMatrix> tmpBuilder = tmpFactory.getBuilder(m,n);
			ix = 0;
	        for (int p = 1; p<constraintMatrices.length; p++) {
	            
	        	double weight = wf.weight(p);
	        	
	        	for(int i=0; i<constraintMatrices[p].length; i++) {
	        		
	            	for (int j = 0; j<n; j++) {
	                    tmpBuilder.set(ix, j, weight * constraintMatrices[p][i][j]);
	                }

	            	ix++;
	        		
	        	}
	        	
	        }
			PrimitiveMatrix tmpM = tmpBuilder.build();
			PrimitiveMatrix tmpQ = tmpM.transpose().multiplyRight(tmpM);
			
			tmpExpr = tmpModel.addExpression("Objective");
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

			//optimize and store violation vector
			Result result = tmpModel.minimise();
			violationVector = new double[m];
			ix = 0;
	        for (int p = 1; p<constraintMatrices.length; p++) {
	            
	        	for(int i=0; i<constraintMatrices[p].length; i++) {
	        		
	        		violationVector[ix] = 0;
	        		
	            	for (int j = 0; j<n; j++) {
	            		violationVector[ix] += wf.weight(p) * constraintMatrices[p][i][j] * result.get(j).doubleValue();
	                }

	            	ix++;
	        		
	        	}
	        	
	        }
			
		}
	
        
        
		
		//now set up the weighted priority entailment problem
		int noVars = noWorlds + 1;
		
		//create non-negative variables 
		tmpVariables = new Variable[noVars];
		for(int i=0; i<noWorlds; i++) {
			tmpVariables[i] = new Variable("p"+i).lower(BigMath.ZERO);
		}
		tmpVariables[noWorlds] = new Variable("y").lower(BigMath.ZERO);
		
		
		//create optimization model			
		tmpModel = new ExpressionsBasedModel(tmpVariables);
		
		
		//generate integrity constraints 
		for(int i=0; i<constraintMatrices[0].length; i++) {
			
			tmpExpr = tmpModel.addExpression("integrityConstraint"+i).level(BigMath.ZERO);
			for(int j=0 ; j<noWorlds; j++) {
				tmpExpr.setLinearFactor(j, constraintMatrices[0][i][j]);
			}
			
		}

		//if knowledge base consists of more than integrity constraints, /generate minimal violation constraints 
		if(priorityKnowledgeBase.length > 1) {	

			ix = 0;
	        for (int p = 1; p<constraintMatrices.length; p++) {
	            
	        	for(int i=0; i<constraintMatrices[p].length; i++) {
	        		
	        		tmpExpr = tmpModel.addExpression("subset of level "+p+" constraint "+i).level(0);
	            	for (int j = 0; j<n; j++) {
	            		tmpExpr.setLinearFactor(j, wf.weight(p) *constraintMatrices[p][i][j]);
	                }
					tmpExpr.setLinearFactor(noWorlds, -violationVector[ix]);
	
	            	ix++;
	        		
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
	
	@Override
	public String toString() {
		return "Weighted Priority Entailment with Euclidean Norm and "+wf;
	}
}
