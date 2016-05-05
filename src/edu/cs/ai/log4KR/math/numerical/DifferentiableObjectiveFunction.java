package edu.cs.ai.log4KR.math.numerical;

public interface DifferentiableObjectiveFunction extends ObjectiveFunction {

	/**
	 * Compute gradient value at given point.
	 * @param x
	 * @return
	 */
	public double[] computeGradientValue(double[] x);
}
