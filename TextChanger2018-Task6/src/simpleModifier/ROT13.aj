package simpleModifier;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect ROT13 {
	
	/**
	 * This aspect enables the feature "ROT13."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {		
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("ROT13")) {
				String result = "";
				
				for (int charPos = 0; charPos < argumentOne.length(); charPos++) {
					
					char inputChar = argumentOne.charAt(charPos);
					
					if (inputChar >= 'a' && inputChar <= 'm') {
						inputChar += 13;
					} else if (inputChar >= 'A' && inputChar <= 'M') {
						inputChar += 13;
					} else if (inputChar >= 'n' && inputChar <= 'z') {
						inputChar -= 13;
					} else if (inputChar >= 'N' && inputChar <= 'Z') {
						inputChar -= 13;
					}
					
					result = result.concat(Character.toString(inputChar));
				}
				
				WriteOutput.write(result);
			}
		}
		
	}

}
