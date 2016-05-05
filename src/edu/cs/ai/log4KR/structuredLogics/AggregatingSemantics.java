package edu.cs.ai.log4KR.structuredLogics;

import java.util.Collection;
import java.util.LinkedList;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.math.numerical.AbstractMatrixBuilder;
import edu.cs.ai.log4KR.relational.classicalLogic.grounding.GroundingOperator;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;
/**
 * The aggregating semantics is defined by aggregating the conditional probabilities of all 
 * ground instances of a conditional.
 *
 * @author NicoPotyka
 *
 */
public class AggregatingSemantics implements RelationalSemantics  {

	
	private GroundingOperator gop;
	private Collection<Constant> consts;
	
	
	public AggregatingSemantics(GroundingOperator gop, Collection<Constant> consts) {
		this.gop = gop;
		this.consts = consts;
	}
	

	
	@Override
	public void initializeConstraintMatrix(AbstractMatrixBuilder matBuilder, Interpretation<RelationalAtom>[] worlds,
			Collection<? extends Conditional<RelationalAtom>> knowledgeBase) {

		matBuilder.setDimension(knowledgeBase.size(), worlds.length);
		
		//for each conditional the ground knowledge base contains a list containing all its ground instances
		LinkedList<Collection<RelationalConditional>> groundKnowledgeBase = new LinkedList<Collection<RelationalConditional>>();
		
		//for each conditional compute its ground instances and add them to the ground knowledge base
		@SuppressWarnings("unchecked")
		Collection<RelationalConditional> kb = (Collection<RelationalConditional>) knowledgeBase;
		for(RelationalConditional c: kb) {
			
			groundKnowledgeBase.add(gop.groundConditional(c, consts));
			
		}
		
		
		//compute constraints
		int i = 0;
		
		for(Collection<RelationalConditional> groundInstances: groundKnowledgeBase) {

			for(int j=0; j<worlds.length; j++) {
				
				double value = 0;
				
				for(RelationalConditional cond: groundInstances) {
					//conditional applicable?
					if( worlds[j].satisfies(cond.getAntecedence()) ) {
						if( worlds[j].satisfies(cond.getConsequence()) ) {
							//positive effect
							value += (1-cond.getProbability().toFloatingPoint());
						}
						else {
							//negative effect
							value -= cond.getProbability().toFloatingPoint();
						}
					}
				}
				
				matBuilder.setValue(i, j, value);
				
			}
			i++;
		}
		
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
		return "Aggregating Semantics";
	}



	@Override
	public int[][] getVerifyingMatrix(
			Interpretation<RelationalAtom>[] worlds,
			Conditional<RelationalAtom> cond) {

		int mat[][] = new int[1][worlds.length];
		Collection<RelationalConditional> groundConditionals = gop.groundConditional((RelationalConditional) cond, consts);

		for(int j=0; j<worlds.length; j++) {
			
			mat[0][j] = 0; 
			
			for(RelationalConditional gCond: groundConditionals) {
				//conditional applicable?
				if( worlds[j].satisfies(gCond.getAntecedence()) ) {
					if( worlds[j].satisfies(gCond.getConsequence()) ) {
						//conditional verified
						mat[0][j] += 1;
					}
				}
			}
			
		}
		
		return mat;
	}



	@Override
	public int[][] getFalsifyingMatrix(
			Interpretation<RelationalAtom>[] worlds,
			Conditional<RelationalAtom> cond) {

		int mat[][] = new int[1][worlds.length];
		Collection<RelationalConditional> groundConditionals = gop.groundConditional((RelationalConditional) cond, consts);

		for(int j=0; j<worlds.length; j++) {
			
			mat[0][j] = 0; 
			
			for(RelationalConditional gCond: groundConditionals) {
				//conditional applicable?
				if( worlds[j].satisfies(gCond.getAntecedence()) ) {
					if(!worlds[j].satisfies(gCond.getConsequence()) ) {
						//conditional falsified
						mat[0][j] += 1;
					}
				}
			}
			
		}
		
		return mat;
	}


}
