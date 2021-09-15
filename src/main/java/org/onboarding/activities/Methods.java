package org.onboarding.activities;

import java.util.Stack;

/**
 * Methods ask for by On-boarding team at work
 *
 */
public class Methods {
	
	/**
	 * Checks to see if a credit card number is valid.
	 * 
	 * The card number must be between 14 and 19 digits long and pass the Luhn algorithm
	 * 
	 * @param card is the number tied to the card.
	 * @return true if card is between 14-19 digits long and lastDigit equals the calculatedSum.
	 * 
	 * @author Peter Fowler
	 */
	public static boolean verifyCreditCard(Long card) {
		
		StringBuilder cardForUse = new StringBuilder(card.toString());
		
		if (cardForUse.length() < 14 || cardForUse.length() > 19) {
			return false;
		}
		// take the last digit to check if the card number is a valid at the end
		int lastDigit = (int)(card % 10);
		
		// remove the check digit from the number to check against at the end
		cardForUse.deleteCharAt(cardForUse.length() - 1);
		
		cardForUse.reverse();
		
		int sumOfCardNums = 0;
		
		for (int i = 0; i < cardForUse.length(); i++) {
			
			// get the next digit in the series
			int num = Integer.parseInt(String.valueOf(cardForUse.charAt(i)));
			
			// every second digit is multiplied by 2
			num = ((i + 1) % 2 != 0) ? num * 2 : num;

			// if digit became greater than 10, add the numbers together to produce a single digit
			if (num >= 10) {
				 num = (num % 10) + (num / 10);
			}
			 
			// add all the digits together
			sumOfCardNums += num;
		}
		
		int calculatedSum = 10 - (sumOfCardNums %10);
		
		// check the calculated sum against the check digit from before
		if (lastDigit == calculatedSum) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Encrypts a String using the ROT13 technique
	 * 
	 * Letters will be changed to the 13th letter higher than the letter in question, wrapping from z to a if necessary.
	 * Characters that are not letters are not encrypted or changed.
	 * 
	 * @param message is the String to be encrypted.
	 * @return a String that is the message with all the letters shifted 13 letters.
	 * 
	 * @author Peter Fowler
	 */
	public static String encryptROT13(String message) {
		
		// the char array is used to access the letters
		char[] arr = message.toCharArray();
		
		// the string builder will hold the encrypted letters until the end
		StringBuilder sb = new StringBuilder();
		
		for (char a : arr) {
			
			// the current character is assigned to b and if it is a letter it will be encrypted
			char b = a;
			
			// if the character is not a letter it does not go through the encryption process
			if (Character.isLetter(a)) {
				
				// if the letter is smaller than n shift 13 places up the alphabet (b -> o)
				if (a < 'n' && a >= 'a' || a < 'N' && a >= 'A' ) {
					b = (char) (a + 13);
					
				// otherwise shift the letter 13 places down the alphabet (s -> f) so to keep the letter a letter
				}else {
					b = (char) (a - 13);
				}
			}
			// the character, letter or not, is assigned to the string builder to create the encrypted message
			sb.append(b);
		}
		
		// return the encrypted message
		return sb.toString();
	}

	/**
	 * Take a base 10 number and turns it into a base 8 number
	 * 
	 * To turn a number from one base into the equivalent number in a different base,
	 * divide the original number number by the new base and take the remainder as the 
	 * first digit in the new number. Repeat this until all that is left is a remainder 
	 * and you will have the new number.
	 * 
	 * @param decimal a number using base 10
	 * 
	 * @return octal an integer number using base 8
	 */
	public static int decimalToOctal(int decimal) {
		
		// will put each digit in a stack
		Stack<Integer> stack = new Stack<Integer>();
		
		// will put the digits from the stack into a string builder
		StringBuilder sb = new StringBuilder();
		
		// if keepGoing is true the do-while loop will continue
		// if the decimal number is less than or equal to 8 keepGoing will be set to false
		boolean keepGoing = true;
		
		// converting the number for base 10 to base 8
		do {
			
			// if the last number is an 8, put a 10 in the stack instead of a 0
			if (decimal <= 8) {
				
				// time to end the do-while loop
				keepGoing = false;
				
				int temp = decimal % 8;
				
				if (temp == 0) {
					temp = 10;
				}
				stack.push(temp);
				
			// if it is not the last number put the remainder of number divided by 8 into the stack
			}else {				
				stack.push(decimal % 8);
			}
			
			// Divide by 8 to get the next number ready
			decimal /= 8;

		}while (keepGoing);
		
		// assemble the new number from the stack
		while (!stack.empty()) {
			sb.append(stack.pop());
		}
		
		// turn the string builder number into an int
		int octal = Integer.valueOf(sb.toString());
		
		// return the new octal number
		return octal;
	}
}
