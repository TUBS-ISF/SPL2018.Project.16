import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
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
			String operation = Parameters.getOperation();
			String argumentOne = Parameters.getArgumentOne();
			String argumentTwo = Parameters.getArgumentTwo();
			
			final ManageOneArgument manageOne;
			final ManageTwoArguments manageTwo;
			
			final String inputUpper = argumentOne.toUpperCase();
			
			if (operation.equalsIgnoreCase("UpperCase")) {
				WriteOutput.write(inputUpper);
				Parameters.setFeatureUsedTrue();
			}
		}
		
	}

}
