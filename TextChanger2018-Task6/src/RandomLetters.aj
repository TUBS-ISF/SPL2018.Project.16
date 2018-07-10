import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect RandomLetters {
	
	/**
	 * This aspect enables the feature "RandomLetters."
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
			
			if (operation.equalsIgnoreCase("RandomLetters")) {
				manageOne = new ManageOneArgument(new randomGenerator.RandomLetters(), argumentOne);
				result = manageOne.startCalculating();
				WriteOutput.write(result);
				
				Parameters.setFeatureUsedTrue();
			}
		}
		
	}

}
