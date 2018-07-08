import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect RandomString {
	
	/**
	 * This aspect enables the feature "RandomString."
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
		
		if (operation.equalsIgnoreCase("RandomString")) {
			Parameters.setFeatureUsedTrue();
			manageOne = new ManageOneArgument(new randomGenerator.RandomString(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
