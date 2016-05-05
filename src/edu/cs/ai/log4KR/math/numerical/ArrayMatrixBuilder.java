package edu.cs.ai.log4KR.math.numerical;

public class ArrayMatrixBuilder extends AbstractMatrixBuilder {

	private double[][] matrix;
	

	@Override
	public void setDimension(int rows, int cols) {
		super.setDimension(rows, cols);
		this.matrix = new double[rows][cols];
	}
	
	@Override
	public void setValue(int row, int col, double val) {
		matrix[row][col] = val;
	}

	public double[][] getMatrix() {
		return matrix;
	}

}
