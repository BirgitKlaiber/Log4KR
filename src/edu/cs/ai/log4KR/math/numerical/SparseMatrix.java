package edu.cs.ai.log4KR.math.numerical;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Simple sparse matrix implementation. The goal is to provide efficient matrix-vector multiplication 
 * rather than to save memory. Therefore, each entry is stored twice to support efficient vector 
 * multiplication from left and right.
 * 
 * Use unchecked operations to perform operations without checking the dimensions of vectors.
 * 
 * @author NicoPotyka
 *
 */
public class SparseMatrix extends AbstractSparseMatrix {

	
	private Vector<LinkedList<IndexValuePair>> rows;
	private Vector<LinkedList<IndexValuePair>> cols;
	
	private double[][] rowsVals;
	private int[][] rowsIndices;
	private double[][] colsVals;
	private int[][] colsIndices;
	
	
	public SparseMatrix(int rows, int cols) {
		
		super(rows,cols);
		
		this.rows = new Vector<LinkedList<IndexValuePair>>(rows);
		for(int i=0; i<rows; i++) {
			this.rows.add(i, new LinkedList<IndexValuePair>());
		}
		this.rows.trimToSize();
		
		this.cols = new Vector<LinkedList<IndexValuePair>>(cols);
		for(int i=0; i<cols; i++) {
			this.cols.add(i, new LinkedList<IndexValuePair>());
		}
		this.cols.trimToSize();
	}
	
	
	@Override
	public void addNewEntryUnchecked(int row, int col, double x) {

		rows.get(row).add(new IndexValuePair(col,x));
		cols.get(col).add(new IndexValuePair(row,x));
	}
	
	/**
	 * After setting all entries, call this method.
	 */
	@Override
	public void initialize() {
		
		if(initialized) return;
		
		//initialize row arrays
		rowsVals = new double[rows.size()][];
		rowsIndices = new int[rows.size()][];
		for(int i=0; i<rows.size(); i++) {
			rowsVals[i] = new double[rows.get(i).size()];
			rowsIndices[i] = new int[rows.get(i).size()];
			int j=0;
			Collections.sort(rows.get(i));
			for(IndexValuePair p: rows.get(i)) {
				rowsVals[i][j] = p.value;
				rowsIndices[i][j] = p.index;
				j++;
			}
		}
		rows = null;

		//initialize column arrays
		colsVals = new double[cols.size()][];
		colsIndices = new int[cols.size()][];
		for(int i=0; i<cols.size(); i++) {
			colsVals[i] = new double[cols.get(i).size()];
			colsIndices[i] = new int[cols.get(i).size()];
			int j=0;
			Collections.sort(cols.get(i));
			for(IndexValuePair p: cols.get(i)) {
				colsVals[i][j] = p.value;
				colsIndices[i][j] = p.index;
				j++;
			}
		}
		cols = null;
		
		initialized = true;
		
	}

	/**
	 * Multiply x from right with row of matrix.
	 * @param row
	 * @param x
	 * @return
	 */
	public double multiplyFromRightWithRow(int row, double[] x) {
		
		if(!initialized) {
			throw new IllegalStateException("Initialize matrix before performing operations.");
		}
		
		if(x.length > noCols) {
			throw new IllegalArgumentException(x.length+"-dimensional vector cannot "
					+ "be multiplied by ("+noRows+","+noCols+")-Matrix  from right.");
		}
		
		return multiplyFromRightWithRowUnchecked(row,x);
	}
	
	/**
	 * Multiply x from right with row of matrix.
	 * User has to assure that x has the right dimension.
	 * @param row
	 * @param x
	 * @return
	 */
	public double multiplyFromRightWithRowUnchecked(int row, double[] x) {

		double res = 0;
		
		for(int j=0; j<rowsVals[row].length; j++) {
			res += x[rowsIndices[row][j]] * rowsVals[row][j];
		}
		
		return res;
		
	}

	/**
	 * Multiply x from left with column of matrix.
	 * @param col
	 * @param x
	 * @return
	 */
	public double multiplyFromLeftWithColumn(int col, double[] x) {

		if(!initialized) {
			throw new IllegalStateException("Initialize matrix before performing operations.");
		}
		
		if(x.length > noRows) {
			throw new IllegalArgumentException(x.length+"-dimensional vector cannot "
					+ "be multiplied by ("+noRows+","+noCols+")-Matrix  from left.");
		}
		
		return multiplyFromLeftWithColumnUnchecked(col,x);
	}
	
	/**
	 * Multiply x from left with column of matrix.
	 * User has to assure that x has the right dimension.
	 * @param x
	 * @return
	 */
	public double multiplyFromLeftWithColumnUnchecked(int col, double[] x) {

		double res = 0;
		
		for(int i=0; i<colsVals[col].length; i++) {
			res += x[colsIndices[col][i]] * colsVals[col][i];
		}
		
		return res;
		
	}
	
	
	
//	@Override
//	public String toString() {
//	
//		if(!initialized) return "(matrix not initialized)";
//		
//		StringBuilder sb = new StringBuilder();
//		
//		
//		//for each row
//		int row = 0;
//		for(int i=0; i< rowsIndices.length; i++) {
//			
//			//print row containing only "_" entries for each 0-row
//			while(col<rowsIndices[i][j]) {
//				sb.append("_ ");
//				col++;	
//			}
//			
//			int col = 0;
//			
//			//for each non-zero entry in row
//			for(int j=0; j<rowsIndices[i].length; j++) {
//				
//				//print "_" for each 0 entry before next non-0 entry
//				while(col<rowsIndices[i][j]) {
//					sb.append("_ ");
//					col++;	
//				}
//				
//				//print next non-0 entry
//				sb.append(rowsVals[i][j]+" ");
//				col++;	
//				
//			}
//
//			//print 0 entries after last non-0 entry
//			for(;col<noCols; col++) {
//				sb.append("_ ");
//				col++;	
//			}
//			
//			//print new line for next row
//			sb.append("\n");
//			
//		}
//		
//		return sb.toString();
//	}
}
