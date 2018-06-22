package main;

public class InputManager {
	
	static String manage(String input) {
		
		final String result;
		
		final String operation = input.split("\\s+")[0].toLowerCase();
		final String argumentOne;
		
		final ManageOneArgument manageOne;
		
		// number arguments (without the operation itself)
		final int numberArguments = input.split("\\s+").length - 1;
		
		// creates variables argumentOne and ArgumentTwo
		if (numberArguments >= 1) {
			argumentOne = input.split("\\s+")[1];
		} else {
			argumentOne = null;
		}
		
		if (operation.equalsIgnoreCase("MD5")) {
			manageOne = new ManageOneArgument(new hashFunction.MD5(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		return original(input);
		
	}
	
}
