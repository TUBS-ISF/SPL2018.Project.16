package randomGenerator;

import java.security.SecureRandom;

public class RandomNumber {
	
	public static String calculate(int length) {
		
		// calculates a random number in SecureRandom format.
		SecureRandom secran = new SecureRandom();
		
		// the maximum value of the generated random number
		int maxRandom = (int) Math.pow(10, length); //10 ** length;
		
		// calculates an random number between 0 and the calculated maximum value
		int randomInt = secran.nextInt(maxRandom);
		
		// convert int to String
		String randomStr = String.valueOf(randomInt);
		
		// add leading zeros, if necessary
		randomStr = String.format("%0" + length + "d", randomInt);
		
		// returns the result
		return randomStr;
		
	}
}
