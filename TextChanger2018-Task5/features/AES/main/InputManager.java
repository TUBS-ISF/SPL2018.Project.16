package main;

public class InputManager {
	
	static String manage(String input) {
		
		final String result;
		
		final String operation= input.split("\\s+")[0].toLowerCase();
		final String argumentOne= input.split("\\s+")[1];
		final String argumentTwo= input.split("\\s+")[2];
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;	
		
		
		if (operation.equalsIgnoreCase("AES")) {
			manageTwo = new ManageTwoArguments(new enDeCrypt.AES(), argumentOne, argumentTwo);
			result = manageTwo.startCalculating();
			return result;
		}

		
		return original(input);
		
	}
	
}