package edu.cs.ai.log4KR.math.numerical;

/**
 * An IndexValuePair can represent a non-zero entry in sparse matrices.
 * 
 * @author NicoPotyka
 *
 */
public class IndexValuePair implements Comparable<IndexValuePair> {
	
	int index;
	double value;
	
	public IndexValuePair(int index, double value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(IndexValuePair p) {
		return index-p.index;
	}
	
}
