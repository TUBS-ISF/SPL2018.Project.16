package main;

public class InputManager {
	
	static String manage(String input) {
		
		final String result;
		
		final String operation= input.split("\\s+")[0].toLowerCase();
		final String argumentOne= input.split("\\s+")[1];
		
		final ManageOneArgument manageOne;		
		
		
		if (operation.equalsIgnoreCase("RandomNumber")) {
			manageOne = new ManageOneArgument(new randomGenerator.RandomNumber(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		
		return original(input);
		
	}
	
}