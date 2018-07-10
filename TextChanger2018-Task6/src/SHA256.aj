import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect SHA256 {
	
	/**
	 * This aspect enables the feature "SHA256."
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
			
			if (operation.equalsIgnoreCase("SHA256")) {
				manageOne = new ManageOneArgument(new hashFunction.SHA256(), argumentOne);
				result = manageOne.startCalculating();
				WriteOutput.write(result);
				
				Parameters.setFeatureUsedTrue();
			}
		}
		
	}

}
