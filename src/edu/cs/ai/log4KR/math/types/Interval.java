package edu.cs.ai.log4KR.math.types;

/**
 * An interval [a,b]. 
 * 
 * @author NicoPotyka
 *
 */
public class Interval {

	private double lower, upper;
	
	public Interval(double lower, double upper) {
		this.lower = lower;
		this.upper = upper;
	}
	
	public void intersect(Interval i) {
		lower = Math.max(lower, i.lower);
		upper = Math.min(upper, i.upper);
	}
	
	public void union(Interval i) {
		lower = Math.min(lower, i.lower);
		upper = Math.max(upper, i.upper);
	}
	
	@Override
	public String toString() {
		
		return "["+lower+", "+upper+"]";
		
	}

	public double getLower() {
		return lower;
	}

	public double getUpper() {
		return upper;
	}
	
}
