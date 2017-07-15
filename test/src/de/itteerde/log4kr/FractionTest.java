package de.itteerde.log4kr;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.cs.ai.log4KR.math.types.Fraction;

public class FractionTest {

	@Test
	public void testConstructorDouble(){
		double p = 3.9682291970525344E-9d;
		Fraction f = new Fraction(p).simplify();//overrun
		assertEquals(p, f.toFloatingPoint(),0.00000001);
	}
	
	@Test
	public void testAddition() {
		
		Fraction.setDisplayType(Fraction.DISPLAY_AS_FRACTION);

		Fraction a = new Fraction(123456789,500000000);
		Fraction b = new Fraction(123456789,500000000);
		
		Fraction aPlusB = new Fraction(123456789,250000000);
		
		assertEquals(aPlusB, Fraction.addition(a, b));
		
		a = new Fraction(3318015558621973l,500000000000000l);
		b = new Fraction(207376203747239l,312500000000000l);

		aPlusB = new Fraction(18249087423087777l,2500000000000000l);
		
		assertEquals(aPlusB, Fraction.addition(a, b));
		

		Fraction c = new Fraction(1659009313165153l,2500000000000000l);
	}

}