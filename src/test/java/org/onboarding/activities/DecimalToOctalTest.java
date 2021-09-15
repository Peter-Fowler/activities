package org.onboarding.activities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DecimalToOctalTest {

	/**
	 * Test whether DecimalToOctal() can handle an 8
	 */
	@Test
	void testSimpleDecimalToOctal() {
		int decimal = 8;
		int octal = Methods.decimalToOctal(decimal);
		
		assertTrue(octal == 10);
	}
	
	/**
	 * Test whether DecimalToOctal() can handle more than one number
	 */
	@Test
	void testThreeDigitDecimalToOctal() {
		int decimal = 123;
		int octal = Methods.decimalToOctal(decimal);
		
		assertTrue(octal == 173);
	}

	/**
	 * Test whether DecimalToOctal() can handle more than one number with a leading 8
	 */
	@Test
	void testThreeDigitWithLeadingEightDecimalToOctal() {
		int decimal = 859;
		int octal = Methods.decimalToOctal(decimal);
		
		assertTrue(octal == 1533);
	}

}
