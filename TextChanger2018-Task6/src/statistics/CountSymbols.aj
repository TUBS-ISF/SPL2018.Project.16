package statistics;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect CountSymbols {
	
	/**
	 * This aspect enables the feature "CountSymbols."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("CountSymbols")) {
				// calculate the length of the input
				final int resultInt = argumentOne.length();
				
				// convert to String, since string is needed for output
				final String resultString = "Number of Symbols: " + String.valueOf(resultInt);
				
				// return the result
				WriteOutput.write(resultString);
			}
		}
		
	}

}
