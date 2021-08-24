package org.onboarding.activities;

/**
 * Methods ask for by On-boarding team at work
 *
 */
public class Methods {
	
	public static boolean varigyCreditCard(Long card) {
		// take the last digit to check if the card number is a valid at the end
		int lastDigit = (int)(card % 10);
		
		StringBuilder cardForUse = new StringBuilder(card.toString());
		
		// remove the check digit from the number
		cardForUse.deleteCharAt(cardForUse.length() - 1);
		
		cardForUse.reverse();
		
		int sumOfCardNums = 0;
		
		for (int i = 0; i < cardForUse.length(); i++) {
			
			int num = Integer.parseInt(String.valueOf(cardForUse.charAt(i)));
		
			num = ((i + 1) % 2 != 0) ? num * 2 : num;

			if (num >= 10) {
				 num = (num % 10) + (num / 10);
			}
			 
			sumOfCardNums += num;
		}
		
		if (lastDigit == 10 - (sumOfCardNums %10)) {
			return true;
		}else {
			return false;
		}
	}
	
}
