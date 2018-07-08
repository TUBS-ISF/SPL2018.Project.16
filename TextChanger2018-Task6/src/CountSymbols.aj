import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect CountSymbols {
	
	/**
	 * This aspect enables the feature "CountSymbols."
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
		
		if (operation.equalsIgnoreCase("CountSymbols")) {
			manageOne = new ManageOneArgument(new statistics.CountSymbols(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
		}
		
	}

}
