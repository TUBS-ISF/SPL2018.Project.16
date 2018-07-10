package statistics;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect LongComSub {
	
	/**
	 * This aspect enables the feature "LongComSub."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {		
			
			String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			final String argumentTwo = Parameters.getArgumentTwo();
			
			if (operation.equalsIgnoreCase("LongComSub")) {
				final String result;
				
				int startPosition = 0;
				int endPosition = 0;
				
				for (int i = 0; i < argumentOne.length(); i++) {
					
					for (int j = 0; j < argumentTwo.length(); j++) {
						
						int currentChar = 0;
						while (argumentOne.charAt(i + currentChar) == argumentTwo.charAt(j + currentChar)) {
							
							currentChar++;
							if (i + currentChar >= argumentOne.length()
									|| j + currentChar >= argumentTwo.length()) {
								break;
							}
						}
						// replace > with >= to get the last substring (instead the first),
						// if serveral longest common substrings of same length exists
						if (currentChar > endPosition) {
							endPosition = currentChar;
							startPosition = i;
						}
					}
				}
				
				final String longComSub = "Longest common Substring: "
						+ argumentOne.substring(startPosition, (startPosition + endPosition));
				
				// checks for empty result (if no common substring was found.)
				if (longComSub.isEmpty()) {
					result = "<Note: No Common Substring found.>";
				} else {
					result = longComSub;
				}
				
				WriteOutput.write(result);
			}
		}
		
	}

}
