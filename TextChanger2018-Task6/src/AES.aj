import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect AES {
	
	/**
	 * This aspect enables the feature "AES."
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
		
		if (operation.equalsIgnoreCase("AES")) {
			manageTwo = new ManageTwoArguments(new enDeCrypt.AES(), argumentOne, argumentTwo);
			result = manageTwo.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
