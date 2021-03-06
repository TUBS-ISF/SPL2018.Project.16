package simpleModifier;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect UpperCase {
	
	/**
	 * This aspect enables the feature "UpperCase."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("UpperCase")) {
				
				final String inputUpper = argumentOne.toUpperCase();
				
				WriteOutput.write(inputUpper);

			}
		}
		
	}

}
