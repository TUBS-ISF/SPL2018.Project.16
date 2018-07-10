package simpleModifier;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect LowerCase {
	
	/**
	 * This aspect enables the feature "LowerCase."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {		
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("LowerCase")) {
				final String inputLower = argumentOne.toLowerCase();
				
				WriteOutput.write(inputLower);
			}
		}
		
	}

}
