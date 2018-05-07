package main;

import simpleModifier.*;

public class inputManager {
	
	static String readParameter(String input, int number) {
		
		String parameter = input.split("\\s+")[number];
		
		return parameter;
		
	}
	
	static String manage(String input) {
		
		// initialise empty String for result.
		String result = "";
		
		// saves operation in parameter 'operation'
		String operation = readParameter(input, 0);
		
		// variable 'operation' is made lowercase to ignore uppercase/lowercase in input
		operation = operation.toLowerCase();
		
		if (operation.equals("exit") || operation.equals("quit")) {
			System.exit(0);
			
		} else if (operation.equals("uppercase") && Available.UpperCase()) {
			
			try {
				String content = readParameter(input, 1);
				
				result = upperCase.make(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				WriteOutput.write("Error: Missing Argument: Nothing to make UpperCase found.");
			}
			
		} else if (operation.equals("lowercase") && Available.LowerCase()) {
			
			try {
				String content = readParameter(input, 1);
				
				result = lowerCase.make(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				WriteOutput.write("Error: Missing Argument: Nothing to make LowerCase found.");
			}
			
		} else if (operation.equals("randomnumber") && Available.RandomNumber()) {
			
			try {
				
				String lengthStr = readParameter(input, 1);
				
				try {
					
					int lengthInt = Integer.parseInt(lengthStr);
					
					result = randomGenerator.RandomNumber.calculate(lengthInt);
					
				} catch (NumberFormatException e) {
					WriteOutput.write("Error: Wrong Argument: Length of random number was not an number. (Given: '" + lengthStr + "')");
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				WriteOutput.write("Error: Missing Argument: Length of random number not found.");
			}
			
		} else if (operation.equals("license")){
			
			result = introduction.license();
			
		} else {
			result = "Unknown command '" + operation + "'. Type 'help' for a list of all allowed operators.";
		}
		
		return result;
		
	}
	
}
