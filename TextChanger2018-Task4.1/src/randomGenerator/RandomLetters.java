package randomGenerator;

import java.security.SecureRandom;

public class RandomLetters implements interfaces.OneArgument {
	
	/**
	 * This class calculated an random String (numbers and letters) of given length.
	 * 
	 * @param length
	 *        The length (number of digits) of the desired random number
	 * @return
	 */
	@Override
	public String calculate(String lengthStr) {
		
		final int length;
		String result = "";
		
		// convert the string to int. Checks if the input was a number at all.
		try {
			length = Integer.parseInt(lengthStr);
			
		} catch (NumberFormatException e) {
			return "Error: Wrong Argument: Length of random number was not an number. (Given: \""
					+ lengthStr + "\")";
		}
		
		// raise warning if a nummber of length '0' was requested.
		if (length == 0) {
			return "Error: Wrong Argument: Length of random number was defines as '0'.";
		}
		
		// The alphabet of all possible characters.
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		// Initialise the random generator
		SecureRandom random = new SecureRandom();
		
		for (int indexCurrent = 0; indexCurrent < length; indexCurrent++) {
			
			char character = alphabet.charAt(random.nextInt(52));
			result = result.concat(Character.toString(character));
		}
		
		return result;
	}
	
}
