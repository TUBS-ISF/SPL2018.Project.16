import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect LowerCase {
	
	/**
	 * This aspect enables the feature "LowerCase."
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
		
		if (operation.equalsIgnoreCase("LowerCase")) {
			manageOne = new ManageOneArgument(new simpleModifier.LowerCase(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
