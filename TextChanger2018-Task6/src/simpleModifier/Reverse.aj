package simpleModifier;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect Reverse {
	
	/**
	 * This aspect enables the feature "Reverse."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {		
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("Reverse")) {
				final String result = new StringBuilder(argumentOne).reverse().toString();
				
				WriteOutput.write(result);
			}
		}
		
	}

}
