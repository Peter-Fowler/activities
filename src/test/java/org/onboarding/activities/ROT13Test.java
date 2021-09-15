package org.onboarding.activities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 * Unit test for Methods.encryptROT13
 * 
 * @author Peter Fowler
 *
 */
public class ROT13Test {

	/**
	 * Tests the method encryptROT13 using a single word
	 */
	@Test
	public void testAWordEncryptROT13() {
		
		String word = "Encrypted";
		
		// use the encryption method to encrypt the word
		String encryptedWord = Methods.encryptROT13(word);
		
		// make sure they do not equal each other
		assertFalse(word.equals(encryptedWord));
		
		// make user that the encrypted word equals what it should
		assertTrue(encryptedWord.equals("Rapelcgrq"));
	}
	
	/**
	 * Tests the method encryptROT13 using multiple words
	 */
	@Test
	public void testMessageEncryptROT13() {
		
		String word = "The quick brown fox jumped over the lazy dogs";
		
		// use the encryption method to encrypt the message
		String encryptedWord = Methods.encryptROT13(word);
		
		// make sure they do not equal each other
		assertFalse(word.equals(encryptedWord));
		
		// make user that the encrypted message equals what it should
		assertTrue(encryptedWord.equals("Gur dhvpx oebja sbk whzcrq bire gur ynml qbtf"));
	}
	
	/**
	 * Tests the method encryptROT13 using multiple words and symbols
	 */
	@Test
	public void testMessageWithSymbolsEncryptROT13() {
		
		String word = "These 10 words are 2 be encrypted but not $&!$#";
		
		// use the encryption method to encrypt the message with symbols
		String encryptedWord = Methods.encryptROT13(word);
		
		// make sure they do not equal each other
		assertFalse(word.equals(encryptedWord));
		
		// make user that the encrypted message with symbols equals what it should
		assertTrue(encryptedWord.equals("Gurfr 10 jbeqf ner 2 or rapelcgrq ohg abg $&!$#"));
	}
}
