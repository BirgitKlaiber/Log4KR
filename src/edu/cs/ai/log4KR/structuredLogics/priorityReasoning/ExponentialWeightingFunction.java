package edu.cs.ai.log4KR.structuredLogics.priorityReasoning;

/**
 * w(p) = base^(p-1) (default base = 10)
 * 
 * @author NicoPotyka
 *
 */
public class ExponentialWeightingFunction implements WeightingFunction {

	double base = 10;
	
	
	
	public ExponentialWeightingFunction() {}
	
	public ExponentialWeightingFunction(double base) { 
		this.base = base;
	}
	
	
	
	@Override
	public double weight(double d) {

		double weight = 1;
		for(int i=1; i<d; i++) {
			weight *= base;
		}
		return weight;
	}

	@Override
	public String toString() {
		return "Exponential weight function with base "+base;
	}
}
