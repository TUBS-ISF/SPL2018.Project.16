package main;

public class InputManager {
	
	static String manage(String input) {
		
		final String result;
		
		final String operation = input.split("\\s+")[0].toLowerCase();
		final String argumentOne;
		final String argumentTwo;
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		// number arguments (without the operation itself)
		final int numberArguments = input.split("\\s+").length - 1;
		
		// creates variables argumentOne and ArgumentTwo
		if (numberArguments >= 1) {
			argumentOne = input.split("\\s+")[1];
		} else {
			argumentOne = null;
		}
		if (numberArguments >= 2) {
			argumentTwo = input.split("\\s+")[2];
		} else {
			argumentTwo = null;
		}
		
		if (operation.equalsIgnoreCase("DES")) {
			manageTwo = new ManageTwoArguments(new enDeCrypt.DES(), argumentOne, argumentTwo);
			result = manageTwo.startCalculating();
			return result;
		}
		
		return original(input);
		
	}
	
}
