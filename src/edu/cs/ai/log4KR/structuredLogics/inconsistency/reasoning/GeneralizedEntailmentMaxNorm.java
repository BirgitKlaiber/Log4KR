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
import edu.cs.ai.log4KR.structuredLogics.inconsistency.measure.MinimalViolationMeasureMaxNorm;

/**
 * Generalized Entailment component for Manhattan norm.
 * 
 * @author NicoPotyka
 *
 */
public class GeneralizedEntailmentMaxNorm<I extends Interpretable> extends AbstractGeneralizedEntailmentComponent<I> {

	
	public GeneralizedEntailmentMaxNorm(StructuredSemantics<I> semantics) {
		super(semantics);
	}
	
	
	public void initialize(Interpretation<I>[] possibleWorlds, 
							Collection<? extends Conditional<I>> knowledgeBase,
							Collection<? extends Conditional<I>> integrityConstraints		) {
		
		super.initialize(possibleWorlds, knowledgeBase, integrityConstraints);
		
		MinimalViolationMeasureMaxNorm<I> incMax = new MinimalViolationMeasureMaxNorm<>(possibleWorlds, semantics);
		double incVal;
		incVal = incMax.measureInconsistency(constraintMatrix,integrityConstraintMatrix);
		

		//set up optimization problem 
		int noWorlds = possibleWorlds.length;
		int noVars = noWorlds + 1;
		
		
		//create non-negative variables 
		Variable[] tmpVariables = new Variable[noVars];
		for(int i=0; i<noWorlds; i++) {
			tmpVariables[i] = new Variable("p"+i).lower(BigMath.ZERO);
		}
		tmpVariables[noWorlds] = new Variable("y").lower(BigMath.ZERO);
		
		
		//create optimization model			
		tmpModel = new ExpressionsBasedModel(tmpVariables);
		Expression tmpExpr;
		

		//constraints from knowledge base
		for(int k=0; k<constraintMatrix.length; k++) {
			
			tmpExpr = tmpModel.addExpression("upperKBConstraint"+k).upper(0);
			for(int i=0 ; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, constraintMatrix[k][i]);
			}
			tmpExpr.setLinearFactor(noWorlds, -incVal);
			
			tmpExpr = tmpModel.addExpression("lowerKBConstraint"+k).lower(0);
			for(int i=0 ; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, constraintMatrix[k][i]);
			}
			tmpExpr.setLinearFactor(noWorlds, incVal);

	
		}
		
		
		//generate normalizing constraint
		tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ZERO);
		for(int i=0; i<noWorlds; i++) {
			tmpExpr.setLinearFactor(i, BigMath.ONE);
		}
		tmpExpr.setLinearFactor(noWorlds, -1);

		
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
		return "GEntMax";
	}
	
}
