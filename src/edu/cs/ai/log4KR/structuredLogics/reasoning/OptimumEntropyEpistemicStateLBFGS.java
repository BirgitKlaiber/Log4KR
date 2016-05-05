package edu.cs.ai.log4KR.structuredLogics.reasoning;

import java.util.Collection;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.semantics.PossibleWorldFactory;
import edu.cs.ai.log4KR.logical.semantics.probabilistic.ProbabilityDistribution;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.logical.syntax.probabilistic.Fact;
import edu.cs.ai.log4KR.math.numerical.ArrayMatrixBuilder;
import edu.cs.ai.log4KR.math.numerical.optimization.EntropyDualObjective;
import edu.cs.ai.log4KR.math.numerical.optimization.LBFGSWrapper;
import edu.cs.ai.log4KR.math.numerical.optimization.RelativeEntropyDualObjective;
import edu.cs.ai.log4KR.structuredLogics.StructuredSemantics;

//TODO add documentation
/**
 * An epistemic state that is defined by the principle of optimum entropy. 
 * Belief Changes are computed by L-BFGS.
 * 
 * @author NicoPotyka
 *
 * @param <I>
 */
public abstract class OptimumEntropyEpistemicStateLBFGS<I extends Interpretable> implements EpistemicState<I> {

	protected ProbabilityDistribution<I> dist;
	protected StructuredSemantics<I> semantics;
	protected Collection<? extends Conditional<I>> knowledgeBase;

	protected double[] priorProbabilities;
	
	protected PossibleWorldFactory<I> worldFactory;
	protected LBFGSWrapper lbfgs;
	
	protected boolean initialized;
	
	
	
	public OptimumEntropyEpistemicStateLBFGS(StructuredSemantics<I> semantics) {
		this.semantics = semantics;
		this.lbfgs = new LBFGSWrapper();
		lbfgs.setIprint(new int[]{-1,0});		//disable output on standard output
		lbfgs.setM(50);
		lbfgs.setEps(0.0000001);
		
		this.initialized = false;
	}
	
	
	

	@Override
	public void initialize(Interpretation<I>[] possibleWorlds, Collection<? extends Conditional<I>> knowledgeBase) {
		
		if(possibleWorlds==null || knowledgeBase==null) {
			throw new IllegalArgumentException("You have to provide a set of possible worlds and a knowledge base to initialize epistemic state.");
		}
		
		this.knowledgeBase = knowledgeBase;
		
		
		//generate possible worlds and create uniform distribution as initial prior
		int noWorlds = possibleWorlds.length;
		
		priorProbabilities = new double[noWorlds];
		double p = 1d / noWorlds;
		for(int i=0; i<noWorlds; i++) {
			priorProbabilities[i] = p;
		}
		
		
		//generate constraints and select that probability distribution as initial distribution
		//that satisfies the constraints and maximizes entropy
		dist = new ProbabilityDistribution<I>(possibleWorlds);
		ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
		semantics.initializeConstraintMatrix(matBuilder, dist.getWorldVector(), knowledgeBase);
		double[][] constraints = matBuilder.getMatrix();
		
		double[] lambda = new double[constraints.length+1];
		for(int i=0; i<lambda.length; i++) {
			lambda[i] = 0.5;
		}
		
		EntropyDualObjective entropy = new EntropyDualObjective(constraints, dist.getProbabilityVector());
		lbfgs.solveWithLBFGS(entropy, lambda);
		lbfgs.setIprint(new int[]{0,0});
		
		initialized = true;
		
	}
	
	
	

	@Override
	public void revise(Collection<? extends Conditional<I>> newConditionals) {
		//extend knowledge base and compute probability function that satisfies extended knowledge base
		//and minimizes relative entropy to the prior 
		extendKnowledgeBase(newConditionals);

		ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
		semantics.initializeConstraintMatrix(matBuilder, dist.getWorldVector(), this.knowledgeBase);
		double[][] constraints = matBuilder.getMatrix();
		RelativeEntropyDualObjective relEntropy = new RelativeEntropyDualObjective(constraints, dist.getProbabilityVector(),priorProbabilities);

		double[] lambda = new double[constraints.length+1];
		for(int i=0; i<lambda.length; i++) {
			lambda[i] = 0.5;
		}
		
		lbfgs.solveWithLBFGS(relEntropy, lambda);
		
	}
	


	@Override
	public void update(Collection<? extends Conditional<I>> newConditionals) {
		
		//replace knowledge base with new knowledge base (old knowledge base is implicitly contained in 
		//   current probability distribution)
		this.knowledgeBase = newConditionals;

		//current probability distribution defines new prior probabilities
		System.arraycopy(dist.getProbabilityVector(), 0, priorProbabilities, 0, dist.getProbabilityVector().length);

		ArrayMatrixBuilder matBuilder = new ArrayMatrixBuilder();
		semantics.initializeConstraintMatrix(matBuilder, dist.getWorldVector(), knowledgeBase);
		double[][] constraints = matBuilder.getMatrix();
		RelativeEntropyDualObjective relEntropy = new RelativeEntropyDualObjective(constraints, dist.getProbabilityVector(),priorProbabilities);

		double[] lambda = new double[constraints.length+1];
		for(int i=0; i<lambda.length; i++) {
			lambda[i] = 0.5;
		}
		
		lbfgs.solveWithLBFGS(relEntropy, lambda);
		
	}


	@Override
	public double queryProbability(Formula<I> f) {
		
		if(!initialized) throw new IllegalStateException("Initialize EpistemicState before performing operations.");
		
		return dist.getProbability(f);
	}

	@Override
	public double queryConditionalProbability(Formula<I> f, Formula<I> condition) {
		
		if(!initialized) throw new IllegalStateException("Initialize EpistemicState before performing operations.");
		
		return dist.getConditionalProbability(f, condition);
	}
	
	@Override
	public double query(Conditional<I> c) {
		return queryConditionalProbability(c.getConsequence(), c.getAntecedence());
	}
	
	@Override
	public double query(Fact<I> f) {
		return queryProbability(f.getConsequence());
	}
	
	public void printCurrentProbabilities() {
		dist.printWorldProbabilities();
	}
	
	
	
	

	public ProbabilityDistribution<I> getDist() {
		return dist;
	}




	public Collection<? extends Conditional<I>> getKnowledgeBase() {
		return knowledgeBase;
	}




	public StructuredSemantics<I> getSemantics() {
		return semantics;
	}

	public void setAccuracy(double epsilon) {
		lbfgs.setEps(epsilon);
	}


	protected abstract void extendKnowledgeBase(Collection<? extends Conditional<I>> newConditionals);
	
}
