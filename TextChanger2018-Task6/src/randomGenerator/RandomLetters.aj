package randomGenerator;
import java.security.SecureRandom;

import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect RandomLetters {
	
	/**
	 * This aspect enables the feature "RandomLetters."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {		
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			final String argumentTwo = Parameters.getArgumentTwo();
			
			final ManageOneArgument manageOne;
			final ManageTwoArguments manageTwo;
			
			if (operation.equalsIgnoreCase("RandomLetters")) {
				
				int length = 0;
				String result = "";
				
				// convert the string to int. Checks if the input was a number at all.
				try {
					length = Integer.parseInt(argumentOne);
					
				} catch (NumberFormatException e) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was not an number. (Given: \""
							+ argumentOne + "\")");
				}
				
				// raise warning if a nummber of length '0' was requested.
				if (length == 0) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was defines as '0'.");
				}
				if (length < 0) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was negativ. An positive number is required");
				}
				
				// The alphabet of all possible characters.
				final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
				
				// Initialise the random generator
				final SecureRandom random = new SecureRandom();
				
				for (int indexCurrent = 0; indexCurrent < length; indexCurrent++) {
					
					char character = alphabet.charAt(random.nextInt(52));
					result = result.concat(Character.toString(character));
				}
				
				WriteOutput.write(result);
			}
		}
		
	}

}
