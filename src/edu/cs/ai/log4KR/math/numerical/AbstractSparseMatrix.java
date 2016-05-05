package edu.cs.ai.log4KR.math.numerical;

/**
 * A sparse matrix is a matrix with many zero entries. Therefore, only zero 
 * entries are stored.
 * To use matrix, create it, add entries and initialize it. 
 * You cannot perform operations before initializing the matrix.
 * 
 * Create some implementation ConcreteMatrix with
 * 
 *   new ConcreteMatrix(rows,cols).
 *   
 * Then add elements once with 
 *   
 *   addNewEntry(row,col,x).
 *   
 * addNewEntry is not supposed to check, whether the entry (row,col) already 
 * exists, so never call it twice for the same entry.
 * 
 * Use 
 *   
 *   addNewEntryUnchecked(row,col,x)
 *   
 * to add entries without checking the dimension.
 * 
 * Before you can perform any operation you have to call
 * 
 *    initialize()
 *    
 * to initialize the matrix.
 * 
 * @author NicoPotyka
 *
 */
public abstract class AbstractSparseMatrix {

	protected int noRows, noCols;
	
	protected boolean initialized;
	
	public AbstractSparseMatrix(int rows, int cols) {
		this.noRows = rows;
		this.noCols = cols;
		
		this.initialized = false;
	}
	
	
	public void addNewEntry(int row, int col, double x) {

		if(initialized) throw new IllegalStateException("You cannot add entries after matrix is initialized.");

		if(row >= noRows || col >= noCols) {
			throw new IllegalArgumentException("("+noRows+","+noCols+")-Matrix has no entry ("+row+","+col+").");
		}
		
		addNewEntryUnchecked(row, col, x);
	}
	
	public abstract void addNewEntryUnchecked(int row, int col, double x);
	public abstract void initialize(); 
}
