import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
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
			final String result;
			
			String operation = Parameters.getOperation();
			String argumentOne = Parameters.getArgumentOne();
			String argumentTwo = Parameters.getArgumentTwo();
			
			final ManageOneArgument manageOne;
			final ManageTwoArguments manageTwo;
			
			if (operation.equalsIgnoreCase("ROT13")) {
				manageOne = new ManageOneArgument(new simpleModifier.ROT13(), argumentOne);
				result = manageOne.startCalculating();
				WriteOutput.write(result);
				
				Parameters.setFeatureUsedTrue();
			}
		}
		
	}

}
