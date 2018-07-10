import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect Reverse {
	
	/**
	 * This aspect enables the feature "Reverse."
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
		
		if (operation.equalsIgnoreCase("Reverse")) {
			manageOne = new ManageOneArgument(new simpleModifier.Reverse(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
