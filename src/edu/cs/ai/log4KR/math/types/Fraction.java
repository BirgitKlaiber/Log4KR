package edu.cs.ai.log4KR.math.types;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Fraction implements Comparable<Fraction> {

	private final double ACCURACY = 1e-10;

	private long numerator;
	private long denominator;

	/**
	 * Display fractions as non-simplified fractions like 5/10.
	 */
	public static final int DISPLAY_AS_FRACTION = 0;

	/**
	 * Display fractions as floating point numbers like 0.5.
	 */
	public static final int DISPLAY_AS_FLOAT = 1;

	/**
	 * Display fractions as simplified fraction like 1/2.
	 */
	public static final int DISPLAY_AS_SIMPLIFIED_FRACTION = 2;

	/**
	 * Display fractions as they are stored. It's the same as
	 * {@link #DISPLAY_AS_FRACTION}.
	 */
	public static final int DEBUG = -1;

	private static int displayType = DISPLAY_AS_FLOAT;

	/**
	 * Creates a new fraction using numerator and denominator. Throws
	 * IllegalArgumentException if denominator is zero.
	 * 
	 * @param numerator
	 *            The numerator of the fraction.
	 * @param denominator
	 *            The denominator of the fraction.
	 */
	public Fraction(long numerator, long denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException("Denominator can not be zero.");
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * Creates new fraction using a floating point number. It stores the given
	 * floating point number as the numerator and 1 as denominator. Then keeps
	 * multiplying by 10 until there are no more decimal places.
	 * 
	 * Example: n = 3.14159265, would give us
	 * 
	 * nominator = 314159265 denominator = 100000000
	 * 
	 * So 314159265/100000000 as fraction.
	 * 
	 * @param n
	 */
	public Fraction(double n) {
		long denomDummy = 1;
		BigDecimal numerDummy = BigDecimal.valueOf(n);
		while (numerDummy.doubleValue() - numerDummy.longValue() != 0) {
			denomDummy *= 10;
			numerDummy = numerDummy.multiply(BigDecimal.valueOf(10));
		}
		this.numerator = numerDummy.longValue();
		this.denominator = denomDummy;
	}

	/**
	 * Creates new fraction using a floating point number as a String.
	 * 
	 * Example: frac = "9.81"
	 * 
	 * numerator = 981 denominator = 100
	 * 
	 * so it's 981/100.
	 * 
	 * @param frac
	 */
	public Fraction(String frac) {
		frac = frac.trim();
		String[] numb = frac.split("\\.");

		System.out.println(numb.length);
		long denom = (long) Math.pow(10, numb[1].length());
		long numer = Long.valueOf(numb[0] + numb[1]);
		this.numerator = numer;
		this.denominator = denom;
	}

	/**
	 * Returns the floating point value of this fraction. It divides numerator
	 * by denominator.
	 * 
	 * @return
	 */
	public double toFloatingPoint() {
		return (double) numerator / (double) denominator;
	}

	/**
	 * Returns a string of the form "numerator / denominator".
	 * 
	 * @return
	 */
	public String toFractionString() {
		return "" + numerator + "/" + denominator;
	}

	/**
	 * Reduces this fraction object. Uses the {@link Fraction#gcd(long, long)}
	 * Method and divides numerator and denominator by the gdc.
	 * 
	 * @return A new Fraction object, which represents this fraction simplified
	 */
	public Fraction simplify() {
		long gcd = Fraction.gcd(this.numerator, this.denominator);
		return new Fraction(numerator / gcd, denominator / gcd);
	}

	public long getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException("Denominator can not be zero.");
		this.denominator = denominator;
	}

	public static int getDisplayType() {
		return displayType;
	}

	/**
	 * Sets the display type of Fraction.
	 * 
	 * @param _displayType
	 *            <p>
	 *            <li>{@link #DISPLAY_AS_FRACTION} - Shows probability as
	 *            fraction</li>
	 *            <li>{@link #DISPLAY_AS_FLOAT} - Shows probability as
	 *            float</li>
	 *            <li>{@link #DISPLAY_AS_SIMPLIFIED_FRACTION} - Shows
	 *            probability as simplified fraction</li>
	 */
	public static void setDisplayType(int _displayType) {
		displayType = _displayType;
	}

	/**
	 * Calculates the greatest common divisor by using the Euclid Algorithm.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd(long a, long b) {
		while (b != 0) {
			long h = a % b;
			a = b;
			b = h;
		}
		return a;
	}

	private static BigInteger gcd(BigInteger a, BigInteger b) {

		if (a.signum() == -1 || b.signum() == -1) {
			throw new ArithmeticException("GCD not defined for negative parameters");
		}

		while (b.compareTo(BigInteger.ZERO) != 0) {
			BigInteger h = a.mod(b);
			a = b;
			b = h;
		}

		return a;
	}

	/**
	 * Calculates the least common multiple.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long lcm(long a, long b) {
		if (a > 3037000500l || b > 3037000500l) {// sqrt of Long.MAX_VALUE =
													// 3037000500l hotfix, still
													// not generally correct
			BigInteger aBig = new BigInteger(Long.toString(a));
			BigInteger bBig = new BigInteger(Long.toString(b));

			return aBig.multiply(bBig).divide(gcd(aBig, bBig)).longValue();
		}

		long lcm = a * b / Fraction.gcd(a, b);
		return lcm;
	}

	@Override
	public String toString() {
		switch (displayType) {
		case DISPLAY_AS_FRACTION:
			return this.toFractionString();
		case DISPLAY_AS_FLOAT:
			return "" + this.toFloatingPoint();
		case DISPLAY_AS_SIMPLIFIED_FRACTION:
			return "" + this.simplify().toFractionString();
		default:
			return this.toFractionString();
		}
	}

	/**
	 * Adds b to a.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Fraction addition(Fraction a, Fraction b) {
		long lcm = Fraction.lcm(a.getDenominator(), b.getDenominator());
		long num = a.getNumerator() * (lcm / a.getDenominator()) + b.getNumerator() * (lcm / b.getDenominator());
		return new Fraction(num, lcm);
	}

	/**
	 * Subtracts a by b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Fraction subtraction(Fraction a, Fraction b) {
		long lcm = Fraction.lcm(a.getDenominator(), b.getDenominator());
		long num = a.getNumerator() * (lcm / a.getDenominator()) - b.getNumerator() * (lcm / b.getDenominator());
		return new Fraction(num, lcm);
	}

	/**
	 * Multiplies a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Fraction multiplication(Fraction a, Fraction b) {
		return new Fraction(a.getNumerator() * b.getNumerator(), a.getDenominator() * b.getDenominator()).simplify();
	}

	/**
	 * Divides a by b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Fraction division(Fraction a, Fraction b) {
		if (b.getNumerator() == 0)
			throw new IllegalArgumentException("You can not devide by zero.");
		return new Fraction(a.getNumerator() * b.getDenominator(), a.getDenominator() * b.getNumerator()).simplify();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denominator ^ (denominator >>> 32));
		result = prime * result + (int) (numerator ^ (numerator >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		return Math.abs(other.toFloatingPoint() - this.toFloatingPoint()) < ACCURACY;
	}

	@Override
	public int compareTo(Fraction o) {
		double thisFrac = this.toFloatingPoint();
		double oFrac = o.toFloatingPoint();
		if (thisFrac > oFrac) {
			return 1;
		} else if (thisFrac < oFrac) {
			return -1;
		}
		return 0;
	}

	/*
	 * public static void main(String[] args) { Fraction f1 = new Fraction(5,3);
	 * Fraction f2 = new Fraction(5,3);
	 * 
	 * Fraction.setDisplayType(Fraction.DISPLAY_AS_FRACTION);
	 * 
	 * System.out.println(division(f1, f2));
	 * 
	 * int n = 5000000; Fraction[] fracs = new Fraction[n]; Double[] ds = new
	 * Double[n];
	 * 
	 * for(int i=0; i<n; i++) { long num = 2+(int)(1000*Math.random()); long den
	 * = 2+(int)(1000*Math.random()); fracs[i] = new Fraction(num,den); ds[i] =
	 * (1.0*num)/den; }
	 * 
	 * long timeStart1 = System.currentTimeMillis(); Fraction result = null;
	 * for(int i=1; i<n; i++) { result = multiplication(fracs[i],fracs[i-1]);
	 * result = division(fracs[i],result); } System.out.println(result); long
	 * timeEnd1 = System.currentTimeMillis();
	 * 
	 * long timeStart2 = System.currentTimeMillis(); double res=0; for(int i=1;
	 * i<n; i++) { res = ds[i]*ds[i-1]; res = ds[i]/res; }
	 * System.out.println(res); long timeEnd2 = System.currentTimeMillis();
	 * System.out.println("Time1: "+(timeEnd1-timeStart1));
	 * System.out.println("Time2: "+(timeEnd2-timeStart2)); }
	 */
}
