package edu.cs.ai.log4KR.math.numerical;

/**
 * Abstract class to build up matrices. 
 * Call setDimension to define dimension of matrix. Then use setValue to set the values.
 * @author NicoPotyka
 *
 */
public abstract class AbstractMatrixBuilder {

	protected int rows, cols;
	
	public void setDimension(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	
	public abstract void setValue(int row, int col, double val);
}
