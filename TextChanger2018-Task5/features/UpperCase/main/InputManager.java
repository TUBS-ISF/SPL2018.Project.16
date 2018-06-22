package main;

public class InputManager {
	
	static String manage(String input) {
		
		final String result;
		
		final String operation= input.split("\\s+")[0].toLowerCase();
		final String argumentOne= input.split("\\s+")[1];
		
		final ManageOneArgument manageOne;		
		
		
		if (operation.equalsIgnoreCase("UpperCase")) {
			manageOne = new ManageOneArgument(new simpleModifier.UpperCase(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		// THIS LINE IS IMPORTANT! Otherwise the program won't compile.
		// reason: otherwise result may be undefined. Remember: this is the last time the method is executed. 
		// if something unexpected went wrong. (This code should normally never be reached...)
		result = "Something went wrong if you see this message...";
		
		return result;
		
	}
	
}
