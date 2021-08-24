package org.onboarding.activities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 * Unit test for Methods.varigyCreditCard
 */
public class CardValidationTest {

	/**
	 * Tests the method verifyCreditCard with a good card number
	 */
	@Test
	public void testGoodCreditCardNumber() {
		assertTrue(Methods.verifyCreditCard(1234567890123452L));
	}
	
	/**
	 * Tests the method verifyCreditCard with a bad card number
	 */
	@Test
	public void testBadCreditCardNumber() {
		assertFalse(Methods.verifyCreditCard(1234567890123456L));
	}

}
