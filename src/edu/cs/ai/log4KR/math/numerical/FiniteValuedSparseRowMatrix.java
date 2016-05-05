package edu.cs.ai.log4KR.math.numerical;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 * A FiniteValuedSparseRowMatrix is a sparse matrix whose entries take only 
 * a finite number of values from {0, a1, ..., ak}. Instead of storing
 * each non-zero entry, for each non-zero value a(i) a list of indices
 * with this value is stored for each row. This allows to increase both 
 * numerical accuracy and performance.
 * 
 * This class supports only multiplying column vectors from right (with rows).
 * 
 * 
 * 
 * @author NicoPotyka
 *
 */
public class FiniteValuedSparseRowMatrix extends AbstractSparseMatrix {

	private Vector<LinkedList<IndexValuePair>> rows;
	
	private double[][] rowValues;  		//[row][values] 
	private int[][] rowColumnIndices;	//[row][columnIndex]
	private int[][] rowValueIndices;	//[row][valueIndex]
	
	
	
	public FiniteValuedSparseRowMatrix(int rows, int cols) {
		
		super(rows, cols);
		
		this.rows = new Vector<LinkedList<IndexValuePair>>(rows);
		for(int i=0; i<rows; i++) {
			this.rows.add(i, new LinkedList<IndexValuePair>());
		}
		this.rows.trimToSize();
		
	}
	
	
	
	@Override
	public void addNewEntryUnchecked(int row, int col, double x) {

		rows.get(row).add(new IndexValuePair(col,x));
	}

	@Override
	public void initialize() {
		
		if(initialized) return;
		
		rowValues = new double[noRows][];
		rowValueIndices = new int[noRows][];
		rowColumnIndices = new int[noRows][];
		
		//for each row
		for(int i=0; i<rows.size(); i++) {

			//sort row
			LinkedList<IndexValuePair> rowi = rows.get(i);
			Collections.sort(rowi);
			
			
			//initialize indice arrays for row
			rowValueIndices[i] = new int[rowi.size()];
			rowColumnIndices[i] = new int[rowi.size()];
			
			
			//store different values in row in vector
			Vector<Double> values = new Vector<Double>();
			int valueIndex;
			
			
			//for each non-zero entry in row store column index and value index
			int j=0;
			for(IndexValuePair p: rowi) {
				
				valueIndex = getIndex(p.value, values);
				rowValueIndices[i][j] = valueIndex;
				rowColumnIndices[i][j] = p.index;
				
				j++;
			}
			
			
			//store values in row
			rowValues[i] = new double[values.size()];
			for(int k=0; k<values.size(); k++) {
				rowValues[i][k] = values.get(k);
			}
		}
		rows = null;
		
		
		initialized = true;
		
	}
	/**
	 * Return index of value. If value is not already contained in values
	 * it is added at the end.
	 * @param values
	 * @param value
	 * @return
	 */
	private int getIndex(double value, Vector<Double> values) {

		//search for value
		int i=0;
		for( ; i<values.size(); i++) {
			if(values.get(i) == value) { //double values are indeed supposed to be equal here
				return i;
			}
		}
		
		//if value not contained add it
		values.add(i,value);
		
		return i;
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
		
		//for each entry in row, sum up the corresponding entries in x
		double[] sums = new double[rowValues[row].length];
		for(int j=0; j<rowColumnIndices[row].length; j++) {

			sums[rowValueIndices[row][j]] += x[rowColumnIndices[row][j]];

		}
		
		//for each value multiply value by corresponding sum and add result
		for(int j=0; j<rowValues[row].length; j++) {
			
			res += sums[j] * rowValues[row][j];
		
		}

		return res;
		
	}

}
