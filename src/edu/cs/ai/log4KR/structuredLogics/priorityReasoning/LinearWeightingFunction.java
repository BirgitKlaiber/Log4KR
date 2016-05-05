package edu.cs.ai.log4KR.structuredLogics.priorityReasoning;


/**
 * w(p) = factor * p (default factor = 1)
 * 
 * @author NicoPotyka
 *
 */
public class LinearWeightingFunction implements WeightingFunction {

	private double factor = 1;
	
	
	public LinearWeightingFunction() { }
	
	public LinearWeightingFunction(double factor) {
		this.factor = factor;
	}
	
	
	@Override
	public double weight(double d) {
		return factor * d;
	}
	
	@Override
	public String toString() {
		return "Linear weight function with factor "+factor;
	}

}
