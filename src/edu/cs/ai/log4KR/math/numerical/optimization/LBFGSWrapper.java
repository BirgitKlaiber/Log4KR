package edu.cs.ai.log4KR.math.numerical.optimization;

import edu.cs.ai.log4KR.math.numerical.DifferentiableObjectiveFunction;
import edu.cs.ai.log4KR.thirdParty.riso.numerical.LBFGS;
import edu.cs.ai.log4KR.thirdParty.riso.numerical.LBFGS.ExceptionWithIflag;


/**
 * A wrapper class for RISO's LBFGS implementation. It provides a more comfortable interface.
 * @author NicoPotyka
 *
 */
public class LBFGSWrapper {

	//configuration, see thirdParty.riso.numerical.LBFGS.lbfgs for details
	
	
	//number of corrections used in BFGS update (3<=m<=7, greater values result in poor performance)
	private int m=3;
	
	
	//provide diagonal, diag has to be initialized to avoid a null pointer exception
	private boolean provideDiag = false;
	private double[] diag = null;
	
	
	//output frequency, output type 
	private int[] iprint = new int[]{1, 1};
	
	
	//solution accuracy
	private double eps = 0.00001;
	

	//estimate of machine precision
	private static double xtol = calculateMachineEpsilonDouble();
	
	
	//control flag
	private int[] iflag = new int[]{0};
	
	
	
	
	
	public LBFGSWrapper() {
		//do nothing, see default configuration above
	}
	
	
	/**
	 * Solve minimization problem for passed objective function using initial point x.
	 * The solution is written into the passed array x.
	 * @param objective
	 * @param x0
	 * @return 0 if computation was successful.
	 */
	public int solveWithLBFGS(DifferentiableObjectiveFunction objective, double[] x) {

		if(!objective.validInput(x)) {
			throw new IllegalArgumentException("Invalid initial input x.");
		}
		
		diag = new double[x.length];
		
		try {
			
			do {
				
				if(iflag[0]==2){
					//diagonal evaluation, should not happen
					throw new Exception("Unexpected requirement of diagonal matrix");
				}
				else if(iflag[0]<0){
					//internal error
					throw new Exception("Internal Error in LBFGS.");
				}
				
				//otherwise function evaluation and LBFGS call
				LBFGS.lbfgs(x.length, 
						m, 
						x, 
						objective.computeFunctionValue(x), 
						objective.computeGradientValue(x), 
						provideDiag, 
						diag, 
						iprint, 
						eps, 
						xtol, 
						iflag);
				
			}
			while(iflag[0]>0);
			
			return 0;
			
		} catch (ExceptionWithIflag e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	
	/**
	 * Modified code from wikipedia: http://en.wikipedia.org/wiki/Machine_epsilon
	 * @return
	 */
	private static double calculateMachineEpsilonDouble() {
        double machEps = 1.0f;
 
        do
           machEps /= 2.0f;
        while ((double) (1.0 + (machEps / 2.0)) != 1.0);
 
        return machEps;
    }





	/**
	 * Number of corrections used in BFGS update (3<=m<=7, greater values result in poor performance).
	 * @return
	 */
	public int getM() {
		return m;
	}

	/**
	 * Number of corrections used in BFGS update (3<=m<=7, greater values result in poor performance).
	 * @return
	 */
	public void setM(int m) {
		this.m = m;
	}


	/**
	 * Contains values for output frequency and output type. 
	 * @return
	 */
	public int[] getIprint() {
		return iprint;
	}

	/**
	 * Contains values for output frequency and output type. 
	 * @return
	 */
	public void setIprint(int[] iprint) {
		this.iprint = iprint;
	}

	/**
	 * Solution accuracy.
	 * @return
	 */
	public double getEps() {
		return eps;
	}

	/**
	 * Solution accuracy.
	 * @return
	 */
	public void setEps(double eps) {
		this.eps = eps;
	}


	/**
	 * Estimated machine precision.
	 * @return
	 */
	public static double getXtol() {
		return xtol;
	}
	
}
