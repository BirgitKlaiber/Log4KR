package edu.cs.ai.log4KR.structuredLogics;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.AbstractMatrixBuilder;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;


/**
 * The propositional semantics interprets a conditional by the relaxed definition of conditional probability
 * (if the probability of the antecedence (condition) is zero, the conditional is satisfied).
 * For worlds (w_i) and a probability vector (p_i) the conditional (B|A)[x] induces the constraint function
 * sum_{w_i satisfies AB} p_i * (1-x) - sum_{w_i satisfies A!B} p_i *x. This can be written as
 * (a_(w_i)) * (p_i), where (a_(w_i)) is a row vector containing entries (1-x), -x, 0 appropriately.
 * 
 * getConstraints returns a matrix A consisting of such row vectors, such that (p_i) satisfies
 * a knowledge base R iff A (p_i) = 0. 
 * 
 * @author NicoPotyka
 *
 */
public class PropositionalSemantics implements StructuredSemantics<PropositionalVariable> {

	@Override
	public void initializeConstraintMatrix(AbstractMatrixBuilder matBuilder, 
			Interpretation<PropositionalVariable>[] worlds,
			Collection<? extends Conditional<PropositionalVariable>> knowledgeBase) {
		
		matBuilder.setDimension(knowledgeBase.size(), worlds.length);
		
		int i = 0;
		
		for(Conditional<PropositionalVariable> cond: knowledgeBase) {
			
			double prob = cond.getProbability().toFloatingPoint();
			
			for(int j=0; j<worlds.length; j++) {
				
				//conditional applicable?
				if(worlds[j].satisfies(cond.getAntecedence()) ) {
					if( worlds[j].satisfies(cond.getConsequence()) ) {
						//positive effect
						matBuilder.setValue(i, j, 1-prob);
					}
					else {
						//negative effect
						matBuilder.setValue(i, j, -prob);
					}
				}
				else {
					//not applicable, no conditional effect
					matBuilder.setValue(i, j, 0);
				}
				
			}
			i++;
		}
		
	}
	

	@Override
	public int[][] getVerifyingMatrix(
			Interpretation<PropositionalVariable>[] worlds, Conditional<PropositionalVariable> cond) {
		
		int mat[][] = new int[1][worlds.length];
		
		for(int j=0; j<worlds.length; j++) {
			
			//conditional applicable?
			if(worlds[j].satisfies(cond.getAntecedence()) ) {
				if( worlds[j].satisfies(cond.getConsequence()) ) {
					//conditional verified
					mat[0][j] = 1;
				}
				else {
					mat[0][j] = 0;
				}
			}
			
		}
		
		return mat;
	}


	@Override
	public int[][] getFalsifyingMatrix(
			Interpretation<PropositionalVariable>[] worlds,  Conditional<PropositionalVariable> cond) {

		int mat[][] = new int[1][worlds.length];
		
		for(int j=0; j<worlds.length; j++) {
			
			//conditional applicable?
			if(worlds[j].satisfies(cond.getAntecedence()) ) {
				if(!worlds[j].satisfies(cond.getConsequence()) ) {
					//conditional falsified
					mat[0][j] = 1;
				}
				else {
					mat[0][j] = 0;
				}
			}
			
		}
		
		return mat;
	}


	@Override
	public String toString() {
		return "Propositional Semantics";
	}


}
