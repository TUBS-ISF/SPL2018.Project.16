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
	after(String input): execution(boolean startPlugins(String)) && args(input) {
		
		final String result;
		
		Parameters para = new Parameters(input);
		String operation = para.getOperation();
		String argumentOne = para.getArgumentOne();
		String argumentTwo = para.getArgumentTwo();
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		if (operation.equalsIgnoreCase("RandomLetters")) {
			Parameters.setFeatureUsedTrue();
			manageOne = new ManageOneArgument(new randomGenerator.RandomLetters(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
