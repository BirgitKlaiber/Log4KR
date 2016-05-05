package edu.cs.ai.log4KR.structuredLogics.reasoning.entailment;

import java.util.Collection;

import org.ojalgo.constant.BigMath;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Variable;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

/**
 * An entailment component computes probability intervals for queries
 * with respect to given knowledge.
 * 
 * @author NicoPotyka
 *
 * @param <I>
 */
public class EntailmentComponent<I extends Interpretable> extends AbstractEntailmentComponent<I> {
	
	public EntailmentComponent(StructuredSemantics<I> semantics) {
		super(semantics);
	}
	
	public void initialize(Interpretation<I>[] possibleWorlds, Collection<? extends Conditional<I>> knowledgeBase) {
		
		super.initialize(possibleWorlds, knowledgeBase);
		
		
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
			
			tmpExpr = tmpModel.addExpression("kbConstraint"+k).level(BigMath.ZERO);
			for(int i=0 ; i<noWorlds; i++) {
				tmpExpr.setLinearFactor(i, constraintMatrix[k][i]);
			}
			
		}
		
		
		//generate normalizing constraint sum(p) - y = 1 
		tmpExpr = tmpModel.addExpression("Normalization").level(BigMath.ZERO);
		for(int i=0; i<noWorlds; i++) {
			tmpExpr.setLinearFactor(i, BigMath.ONE);
		}
		tmpExpr.setLinearFactor(noWorlds, -1);

		
	}
	
}
