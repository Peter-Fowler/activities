package org.onboarding.activities;

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
	
}
