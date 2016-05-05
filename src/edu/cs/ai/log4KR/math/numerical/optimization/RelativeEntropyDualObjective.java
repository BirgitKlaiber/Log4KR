package edu.cs.ai.log4KR.math.numerical.optimization;

import edu.cs.ai.log4KR.math.numerical.DifferentiableObjectiveFunction;

/**
 * Dual of relative entropy. 
 * 
 * Suppose you want to minimize the relative entropy of n probabilities x_i to former probabilities c_i: 
 * 	SUM_i x_i * log( x_i/c_i)
 * subject to A'x = b (A' = A transposed), where A is an (nxm)-matrix representing m linear 
 * constraints over the probabilities.
 * 
 * Then the dual optimization problem is (see Fletcher, Practical Methods of optimization, p. 222)
 * min(lambda) 1/n * SUM_i c_i exp(e_i' * A * lambda - 1)   - lambda' * b,
 * where i ranges over the probabilities and e_i is the i-th unit vector.
 * 
 * 
 * @author NicoPotyka
 *
 */
public class RelativeEntropyDualObjective implements DifferentiableObjectiveFunction {
	
	
	private double[][] A;
	private int n;
	private int m;
	private int normalizationIndex;
	
	private double[] priorProbabilities;
	private double[] currentProbabilities;  //cash probabilities
	private double[] currentLambdas;
	
	
	
	
	/**
	 * Expects (mxn)-matrix A representing linear constraints. Each row corresponds to a linear constraint,
	 * such that Ax=0 for the probability vector x. The normalizing constraint ones' * x = 1 is added automatically.
	 */
	public RelativeEntropyDualObjective(double[][] A, double[] priorProbabilities) {
		this.A = A;
		this.n = A[0].length;
		//additional constraint for normalization
		this.m = A.length + 1;
		normalizationIndex = m-1;
		
		if(priorProbabilities.length != n) {
			throw new IllegalArgumentException("Size of probability vector does not agree with size of constraint matrix.");
		}
		
		this.priorProbabilities = priorProbabilities;
		currentProbabilities = new double[n];
		currentLambdas = new double[m];
	}
	
	/**
	 * Expects (mxn)-matrix A representing linear constraints. Each row corresponds to a linear constraint,
	 * such that Ax=0 for the probability vector x. The normalizing constraint ones' * x = 1 is added automatically.
	 */
	public RelativeEntropyDualObjective(double[][] A, double[] probabilityVector, double[] priorProbabilities) {
		this.A = A;
		this.n = A[0].length;
		//additional constraint for normalization
		this.m = A.length + 1;
		normalizationIndex = m-1;
		
		if(probabilityVector.length != n || priorProbabilities.length != n) {
			throw new IllegalArgumentException("Size of probability vector does not agree with size of constraint matrix.");
		}
		
		this.priorProbabilities = priorProbabilities;
		currentProbabilities = probabilityVector;
		currentLambdas = new double[m];
	}
	
	
	
	@Override
	public boolean validInput(double[] lambda) {
		//one optimization variable for each constraint and x[0] for the normalizing constraint 
		return lambda.length==(m);
	}

	@Override
	public double computeFunctionValue(double[] lambda) {
		
		/*
		 * The dual objective is    1/n sum_i x_i - lambda' b 
		 * where x is the probability vector
		 */
		
		double value = 0;
		
		computeProbs(lambda);
		
		for(int i=0; i<n; i++) {
			value += currentProbabilities[i];
		}
		
		//b_m = 1 and b_i = 0 for i<m, therefore lambda' b = lambda_m
		value -= lambda[normalizationIndex];
		
		return value;
	}

	@Override
	public double[] computeGradientValue(double[] lambda) {
		
		/*
		 * The dual gradient is A x - b, where x is the probability vector and b the constraint value vector [0 ... 0 1]
		 */
		double[] gradient = new double[lambda.length];
		
		computeProbs(lambda);
		
		//normalizing constraint
		gradient[normalizationIndex] = 0;
		for(int i=0; i<currentProbabilities.length; i++) {
			gradient[normalizationIndex] += currentProbabilities[i];
		}
		gradient[normalizationIndex] -= 1;
		
		//constraints
		for(int j=0; j<normalizationIndex; j++) {
			gradient[j] = 0;
			for(int i=0; i<n; i++) {
				gradient[j] += A[j][i]*currentProbabilities[i];
			}
		}
		
		return gradient;
	}
	
	
	private void computeProbs(double[] lambda) {
		
		//check whether cashed lambdas are still valid
		boolean validCash = true;
		
		for(int j=0; j<currentLambdas.length; j++) {
			if(Math.abs(currentLambdas[j] - lambda[j]) > 0.000001) {
				validCash = false;
				break;
			}
		}
		
		//if cashed lambdas are still valid probabilities don't have to be recomputed
		if(validCash) {
			return;
		}
		
		//otherwise update lambda and compute probabilities
		System.arraycopy(lambda, 0, currentLambdas, 0, lambda.length);
		
		//x_i = c_i exp(e_i' A' lambda -1), where e_i is the i-th unit vector
		//c_i is the original probability when minimizing KL-divergence.
		for(int i=0; i<n; i++) {
			double x = 0;
			
			//normalizing constraint
			x += lambda[normalizationIndex];
			
			//constraints
			for(int j=0; j<A.length; j++) {
				x += (A[j][i]*lambda[j]);
			}
			
			currentProbabilities[i] = priorProbabilities[i] * Math.exp(x-1);
		}
	}
	
	public double[] getCurrentProbabilities() {
		return currentProbabilities;
	}
	
	public double[] getCurrentLambdas() {
		return currentLambdas;
	}
	
	public void printCurrentLambdas() {
		for(int j=0; j<currentLambdas.length; j++) {
			System.out.println("Lamba["+j+"] = "+currentLambdas[j]);
		}
	}
	
	public void printCurrentProbabilities() {
		for(int i=0; i<currentProbabilities.length; i++) {
			System.out.println("prob["+i+"] = "+currentProbabilities[i]);
		}
	}
	
	public void printCurrentError() {
		double[] gradient = computeGradientValue(currentLambdas);
		for(int i=0; i<gradient.length; i++) {
			System.out.println("Error for constraint "+i+": "+gradient[i]);
		}
	}

}
