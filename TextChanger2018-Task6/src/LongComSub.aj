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
		
		Parameters para = new Parameters(input);
		String operation = para.getOperation();
		String argumentOne = para.getArgumentOne();
		String argumentTwo = para.getArgumentTwo();
		
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
