package randomGenerator;

import java.security.SecureRandom;

public class RandomNumber implements interfaces.OneArgument {
	
	/**
	 * This class calculated an random number of given length.
	 * 
	 * @param length
	 *        The length (number of digits) of the desired random number
	 * @return
	 */
	@Override
	public String calculate(String lengthStr) {
		
		final int length;
		
		// convert the string to int. Checks if the input was a number at all.
		try {
			length = Integer.parseInt(lengthStr);
			
		} catch (NumberFormatException e) {
			return "Error: Wrong Argument: Length of random number was not an number. (Given: \""
					+ lengthStr + "\")";
		}
		
		// rause warning if a nummber of length '0' was requested.
		if (length == 0) {
			return "Error: Wrong Argument: Length of random number was defines as '0'.";
		}
		if (length < 0) {
			return "Error: Wrong Argument: Length of random number was negativ. An positive number is required";
		}
		
		// calculates a random number in SecureRandom format.
		final SecureRandom secran = new SecureRandom();
		
		// the maximum value of the generated random number
		final int maxRandom = (int) Math.pow(10, length); // 10 ** length;
		
		// calculates an random number between 0 and the calculated maximum
		// value
		final int randomInt = secran.nextInt(maxRandom);
		
		// convert int to String
		String randomStr = String.valueOf(randomInt);
		
		// add leading zeros, if necessary
		randomStr = String.format("%0" + length + "d", randomInt);
		
		// returns the result
		return randomStr;
		
	}
}
