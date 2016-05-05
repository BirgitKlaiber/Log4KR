package edu.cs.ai.log4KR.math.numerical;

public interface ObjectiveFunction {

	/**
	 * Check whether point has a valid format.
	 * @param x
	 * @return
	 */
	public boolean validInput(double[] x);
	
	/**
	 * Compute function value at given point.
	 * @param x
	 * @return
	 */
	public double computeFunctionValue(double[] x);
	
	
}
