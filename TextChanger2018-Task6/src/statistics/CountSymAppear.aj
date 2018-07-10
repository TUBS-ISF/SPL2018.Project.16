package statistics;

import java.util.HashMap;
import java.util.Map;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect CountSymAppear {
	
	/**
	 * This aspect enables the feature "CountSymAppear."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("CountSymAppear")) {
				final String result;
				
				final int inputLength = argumentOne.length();
				
				Map<Character, Integer> numberCharacters = new HashMap<Character, Integer>(
						Math.min(inputLength, 26));
				
				// for all chars of the input
				for (int i = 0; i < inputLength; ++i) {
					
					char charAt = argumentOne.charAt(i);
					
					// if char is not in result add it
					if (!numberCharacters.containsKey(charAt)) {
						
						numberCharacters.put(charAt, 1);
						
					} else {
						// otherwise increase appearance number by one
						numberCharacters.put(charAt, numberCharacters.get(charAt) + 1);
					}
				}
				
				result = numberCharacters.toString();
				
				WriteOutput.write(result);
			}
		}
	}

}
