package org.onboarding.activities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 * Unit test for Methods.varigyCreditCard
 */
public class CardValidationTest {

	
	@Test
	public void testGoodCreditCardNumber() {
		assertTrue(Methods.varigyCreditCard(1234567890123452L));
	}
	
	@Test
	public void testBadCreditCardNumber() {
		assertFalse(Methods.varigyCreditCard(1234567890123456L));
	}

}
