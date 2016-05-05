package edu.cs.ai.log4KR.logical.semantics.probabilistic;

import edu.cs.ai.log4KR.logical.semantics.Interpretation;
import edu.cs.ai.log4KR.logical.syntax.Formula;
import edu.cs.ai.log4KR.logical.syntax.Interpretable;




/**
 * Manages a probability distribution over possible worlds.
 * @author NicoPotyka
 *
 */
public class ProbabilityDistribution<I extends Interpretable> {


	
	protected Interpretation<I>[] worldVector;
	protected double[] probabilityVector;
	
	
	/**
	 * Create uniform probability distribution for worlds.
	 * @param worldVector
	 */
	public ProbabilityDistribution(Interpretation<I>[] worldVector) {
		this.worldVector = worldVector;
		//initialize probabilities uniformly
		probabilityVector = new double[worldVector.length];
		double p = 1d/worldVector.length;
		for(int i=0; i<worldVector.length; i++) {
			probabilityVector[i] = p;
		}
	}
	

	public ProbabilityDistribution(Interpretation<I>[] worldVector, double[] probabilityVector) {
		if(worldVector.length != probabilityVector.length) {
			throw new IllegalArgumentException("Number of worlds does not aggree with number of probabilities.");
		}
		this.worldVector = worldVector;
		this.probabilityVector = probabilityVector;
	}
	
	/**
	 * The probability of a formula is the sum of the probabilities of its models.
	 * @param f
	 * @return
	 */
	public double getProbability(Formula<I> f) {
		
		double p = 0;
		
		for(int i=0; i<worldVector.length; i++) {
			if(worldVector[i].satisfies(f)) {
				p += probabilityVector[i];
			}
		}
		
		return p;
	}

	public double getConditionalProbability(Formula<I> consequence,
			Formula<I> antecedence) {
		
		//P(Antecedence)
		double pAnt = 0;
		//P(Antecedence and Consequence)
		double pAntCons = 0;
		
		for(int i=0; i<worldVector.length; i++) {
			if(worldVector[i].satisfies(antecedence)) {
				
				pAnt += probabilityVector[i];
				
				if(worldVector[i].satisfies(consequence)) {
					pAntCons += probabilityVector[i];
				}
			}
		}
		
		if(pAnt<=0) {
			return -1;
		}
		return pAntCons/pAnt;
	}
	
	public double getEntropy() {
		
		double entropy = 0;
		
		for(int i=0; i<probabilityVector.length; i++) {
			double p = probabilityVector[i];
			if(p>0) {
				entropy -= Math.log(p) * p;
			}
		}
		
		return entropy;
	}

	
	public Interpretation<I>[] getWorldVector() {
		return worldVector;
	}

	public double[] getProbabilityVector() {
		return probabilityVector;
	}

	public void setProbabilityVector(double[] probabilityVector) {
		this.probabilityVector = probabilityVector;;
	}


	public void printWorldProbabilities() {
		for(int i=0; i<worldVector.length; i++) {
			System.out.println(worldVector[i] +": "+probabilityVector[i]);
		}
	}
	
}
