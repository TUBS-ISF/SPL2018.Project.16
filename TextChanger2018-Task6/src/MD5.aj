import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect MD5 {
	
	/**
	 * This aspect enables the feature "UpperCase."
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
		
		if (operation.equalsIgnoreCase("MD5")) {
			manageOne = new ManageOneArgument(new hashFunction.MD5(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
