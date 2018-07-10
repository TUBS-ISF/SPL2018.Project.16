import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect LongComSub {
	
	/**
	 * This aspect enables the feature "LongComSub."
	 * 
	 * @param input
	 *        The Input.
	 */
	after(String input): execution(boolean startPlugins(String)) && args(input) {
		
		final String result;
		
		String operation = Parameters.getOperation();
		String argumentOne = Parameters.getArgumentOne();
		String argumentTwo = Parameters.getArgumentTwo();
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		if (operation.equalsIgnoreCase("LongComSub")) {
			manageTwo = new ManageTwoArguments(new statistics.LongComSub(), argumentOne,
					argumentTwo);
			result = manageTwo.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
