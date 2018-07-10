import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect CountSymAppear {
	
	/**
	 * This aspect enables the feature "CountSymAppear."
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
			
			if (operation.equalsIgnoreCase("CountSymAppear")) {
				manageOne = new ManageOneArgument(new statistics.CountSymAppear(), argumentOne);
				result = manageOne.startCalculating();
				WriteOutput.write(result);
				
				Parameters.setFeatureUsedTrue();
			}
		}
	}

}
