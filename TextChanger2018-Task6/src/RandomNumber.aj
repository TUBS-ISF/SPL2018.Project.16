import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect RandomNumber {
	
	/**
	 * This aspect enables the feature "RandomNumber."
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
			
			if (operation.equalsIgnoreCase("RandomNumber")) {
				manageOne = new ManageOneArgument(new randomGenerator.RandomNumber(), argumentOne);
				result = manageOne.startCalculating();
				WriteOutput.write(result);
				
				Parameters.setFeatureUsedTrue();
			}
		}
		
	}

}
