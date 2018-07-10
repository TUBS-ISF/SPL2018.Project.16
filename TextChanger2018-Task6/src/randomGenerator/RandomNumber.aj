package randomGenerator;

import java.security.SecureRandom;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect RandomNumber {
	
	/**
	 * This aspect enables the feature "RandomNumber."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {		
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("RandomNumber")) {
				int length = 0;
				
				// convert the string to int. Checks if the input was a number at all.
				try {
					length = Integer.parseInt(argumentOne);
					
				} catch (NumberFormatException e) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was not an number. (Given: \""
							+ argumentOne + "\")");
				}
				
				// rause warning if a nummber of length '0' was requested.
				if (length == 0) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was defines as '0'.");
				}
				if (length < 0) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was negativ. An positive number is required");
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
				WriteOutput.write(randomStr);
			}
		}
		
	}

}
