package edu.cs.ai.log4KR.structuredLogics.inconsistency.reasoning;

import java.util.Collection;

import org.ojalgo.constant.BigMath;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Variable;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;
import edu.cs.ai.log4KR.structuredLogics.inconsistency.measure.MinimalViolationMeasure1Norm;

/**
 * Generalized Entailment component for Manhattan norm.
 * 
 * @author NicoPotyka
 *
 */
public class GeneralizedEntailment1Norm<I extends Interpretable> extends AbstractGeneralizedEntailmentComponent<I> {

	
	public GeneralizedEntailment1Norm(StructuredSemantics<I> semantics) {
		super(semantics);
	}
	
	
	public void initialize(Interpretation<I>[] possibleWorlds, 
							Collection<? extends Conditional<I>> knowledgeBase,
							Collection<? extends Conditional<I>> integrityConstraints		) {
		
		super.initialize(possibleWorlds, knowledgeBase, integrityConstraints);
		
		MinimalViolationMeasure1Norm<I> inc1 = new MinimalViolationMeasure1Norm<>(possibleWorlds, semantics);
		double incVal;
		incVal = inc1.measureInconsistency(constraintMatrix,integrityConstraintMatrix);
		

		//set up optimization problem 
		int noWorlds = possibleWorlds.length;
		int noConstraints = constraintMatrix.length;
		int noVars = noWorlds + noConstraints + 1;
		
		
		//create non-negative variables 
		Variable[] tmpVariables = new Variable[noVars];
		for(int i=0; i<noWorlds; i++) {
			tmpVariables[i] = new Variable("p"+i).lower(BigMath.ZERO);
		}
		for(int i=0; i<noConstraints; i++) {
			tmpVariables[noWorlds + i] = new Variable("c"+i).lower(BigMath.ZERO);
		}
		tmpVariables[noWorlds + noConstraints] = new Variable("y").lower(BigMath.ZERO);
		
		
		//create optimization model			
		tmpModel = new ExpressionsBasedModel(tmpVariables);
		Expression tmpExpr;
		

		//constraints from knowledge base
		for(int k=0; k<constraintMatrix.length; k++) {
			
			tmpExpr = tmpModel.addExpression("upperKBConstraint"+k).upper(0);
			for(int i=0 ; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, constraintMatrix[k][i]);
			}
			tmpExpr.setLinearFactor(noWorlds+k, -1);
			
			tmpExpr = tmpModel.addExpression("lowerKBConstraint"+k).lower(0);
			for(int i=0 ; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, constraintMatrix[k][i]);
			}
			tmpExpr.setLinearFactor(noWorlds+k, 1);

	
		}
		
		
		//generate violation constraint
		tmpExpr = tmpModel.addExpression("Violation").level(BigMath.ZERO);
		for(int i=0; i<noConstraints; i++) {
			tmpExpr.setLinearFactor(noWorlds+i, BigMath.ONE);
		}
		tmpExpr.setLinearFactor(noWorlds+noConstraints, -incVal);
		
		
		//generate normalizing constraint
		tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ZERO);
		for(int i=0; i<noWorlds; i++) {
			tmpExpr.setLinearFactor(i, BigMath.ONE);
		}
		tmpExpr.setLinearFactor(noWorlds+noConstraints, -1);

		
		//generate integrity constraints
		if(integrityConstraintMatrix != null) {
			for(int k=0; k<integrityConstraintMatrix.length; k++) {
				
				tmpExpr = tmpModel.addExpression("integrityConstraint"+k).level(BigMath.ZERO);
				for(int i=0 ; i<noWorlds; i++) {
					tmpExpr.setLinearFactor(i, integrityConstraintMatrix[k][i]);
				}
				
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "GEnt1";
	}
	
}
