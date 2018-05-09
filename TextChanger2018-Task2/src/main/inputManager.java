package main;

public class inputManager {
	
	// method to give the parameter of an goven position
	static String readParameter(String input, int number) {
		
		String parameter = input.split("\\s+")[number];
		
		return parameter;
		
	}
	
	/*
	 * static String readContent(String input, int number) {
	 * 
	 * String content = input.substring(number);
	 * 
	 * return content; }
	 */
	
	static String manage(String input) {
		
		// initialise empty String for result.
		String result = "Error: If you see this message, something went wrong.";
		
		// saves operation in parameter 'operation'
		String operation = readParameter(input, 0);
		
		// variable 'operation' is made lowercase to ignore uppercase/lowercase in input
		operation = operation.toLowerCase();
		
		if (operation.equals("exit") || operation.equals("quit")) {
			WriteOutput.write("Exit Program.");
			System.exit(0);
		}
		
		if (operation.equals("license")) {
			result = introduction.license();
			return result;
		}
		
		if (operation.equals("help")) {
			Help.help();
			result = "";
			return result;
		}
		
		if (operation.equals("uppercase") && Available.UpperCase()) {
			
			try {
				String content = readParameter(input, 1);
				
				result = simpleModifier.upperCase.make(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing to make UpperCase found.";
			}
			
			return result;
		}
		
		if (operation.equals("lowercase") && Available.LowerCase()) {
			
			try {
				String content = readParameter(input, 1);
				
				result = simpleModifier.lowerCase.make(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing to make LowerCase found.";
			}
			
			return result;
			
		}
		
		if (operation.equals("randomnumber") && Available.RandomNumber()) {
			
			try {
				String lengthStr = readParameter(input, 1);
				
				try {
					int lengthInt = Integer.parseInt(lengthStr);
					
					result = randomGenerator.RandomNumber.calculate(lengthInt);
					
				} catch (NumberFormatException e) {
					result = "Error: Wrong Argument: Length of random number was not an number. (Given: \"" + lengthStr
							+ "\")";
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Length of random number not found.";
			}
			
			return result;
			
		}
		
		if (operation.equalsIgnoreCase("md5") && Available.MD5()) {
			
			try {
				String content = readParameter(input, 1);
				
				result = hashFunction.MD5.hash(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to hash with MD5.";
			}
			
			return result;
		}
		
		if (operation.equals("countsymbols") && Available.CountSymbols()) {
			
			try {
				String content = readParameter(input, 1);
				
				result = statistics.CountSymbols.count(content);
				
				return result;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to calculate the length of.";
			}
		}
		
		result = "Unknown command '" + operation + "'. Type 'help' for a list of all allowed operators.";
		
		return result;
		
	}
	
}
