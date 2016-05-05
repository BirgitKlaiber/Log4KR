package edu.cs.ai.log4KR.structuredLogics;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.AbstractMatrixBuilder;
import edu.cs.ai.log4KR.relational.classicalLogic.grounding.GroundingOperator;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * The grounding semantics regards each conditional as a template for its ground instances.
 * Each ground instance is interpreted by the relaxed definition of conditional probability
 * (if the probability of the antecedence (condition) is zero, the conditional is satisfied).
 * @author NicoPotyka
 *
 */
public class GroundingSemantics implements RelationalSemantics {

	
	private GroundingOperator gop;
	private Collection<Constant> consts;
	
	
	public GroundingSemantics(GroundingOperator gop, Collection<Constant> consts) {
		this.gop = gop;
		this.consts = consts;
	}
	

	@Override
	public void initializeConstraintMatrix(AbstractMatrixBuilder matBuilder, Interpretation<RelationalAtom>[] worlds,
			Collection<? extends Conditional<RelationalAtom>> knowledgeBase) {
		
		@SuppressWarnings("unchecked")
		Collection<RelationalConditional> groundKnowledgeBase = gop.groundKnowledgeBase((Collection<RelationalConditional>)knowledgeBase, consts);
		
		//create constraints for each ground instance
		matBuilder.setDimension(groundKnowledgeBase.size(), worlds.length);
		
		int i = 0;
		
		for(RelationalConditional cond: groundKnowledgeBase) {
			
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
			Interpretation<RelationalAtom>[] worlds,
			Conditional<RelationalAtom> cond) {

		//create indices for each ground instance
		Collection<RelationalConditional> groundConditionals = gop.groundConditional((RelationalConditional) cond, consts);
		int mat[][] = new int[groundConditionals.size()][worlds.length];

		int i=0;
		for(RelationalConditional gCond: groundConditionals) {

			for(int j=0; j<worlds.length; j++) {
				
				//conditional applicable?
				if(worlds[j].satisfies(gCond.getAntecedence()) ) {
					if( worlds[j].satisfies(gCond.getConsequence()) ) {
						//conditional verified
						mat[i][j] = 1;
					}
					else {
						mat[i][j] = 0;
					}
				}
				
			}
			
			i++;
			
		}
		
		return mat;
	}


	@Override
	public int[][] getFalsifyingMatrix(
			Interpretation<RelationalAtom>[] worlds,
			Conditional<RelationalAtom> cond) {

		//create indices for each ground instance
		Collection<RelationalConditional> groundConditionals = gop.groundConditional((RelationalConditional) cond, consts);
		int mat[][] = new int[groundConditionals.size()][worlds.length];

		int i=0;
		for(RelationalConditional gCond: groundConditionals) {

			for(int j=0; j<worlds.length; j++) {
				
				//conditional applicable?
				if(worlds[j].satisfies(gCond.getAntecedence()) ) {
					if(!worlds[j].satisfies(gCond.getConsequence()) ) {
						//conditional falsified
						mat[i][j] = 1;
					}
					else {
						mat[i][j] = 0;
					}
				}
				
			}
			
			i++;
			
		}
		
		return mat;
	}


	@Override
	public GroundingOperator getGop() {
		return gop;
	}


	public void setGop(GroundingOperator gop) {
		this.gop = gop;
	}


	public Collection<Constant> getConsts() {
		return consts;
	}


	public void setConsts(Collection<Constant> consts) {
		this.consts = consts;
	}

	@Override
	public String toString() {
		return "Grounding Semantics";
	}

}
