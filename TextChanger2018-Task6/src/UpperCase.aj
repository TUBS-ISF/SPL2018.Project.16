import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect UpperCase {
	
	/**
	 * This aspect enables the feature "UpperCase."
	 * 
	 * @param input
	 *        The Input.
	 */
	after(String input): execution(boolean startPlugins(String)) && args(input) {
		
		
		String operation = Parameters.getOperation();
		String argumentOne = Parameters.getArgumentOne();
		String argumentTwo = Parameters.getArgumentTwo();
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		final String inputUpper = argumentOne.toUpperCase();
		
		if (operation.equalsIgnoreCase("UpperCase")) {
			WriteOutput.write(inputUpper);
			Parameters.setFeatureUsedTrue();
		}
		
		/*
		if (operation.equalsIgnoreCase("UpperCase")) {
			manageOne = new ManageOneArgument(new simpleModifier.UpperCase(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		*/
		
	}

}
