package main;

public class inputManager {
	
	// method to give the parameter of an goven position
	static String readParameter(String input, int number) {
		
		String parameter = input.split("\\s+")[number];
		
		return parameter;
		
	}
	
	static String manage(String input) {
		
		// initialise empty String for result.
		String result = "Error: If you see this message, something went wrong.";
		
		// saves operation in parameter 'operation'
		String operation = readParameter(input, 0);
		
		if (operation.equalsIgnoreCase("exit") || operation.equalsIgnoreCase("quit") || operation.equalsIgnoreCase("q")) {
			WriteOutput.write("Exit Program.");
			System.exit(0);
		}
		
		if (operation.equalsIgnoreCase("license")) {
			result = Texts.license();
			return result;
		}
		
		if (operation.equalsIgnoreCase("help")) {
			Texts.help();
			result = "";
			return result;
		}
		
		// #if UpperCase
		if (operation.equalsIgnoreCase("uppercase")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = simpleModifier.upperCase.make(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing to make UpperCase found.";
			}
			
			return result;
		}
		// #endif
		
		// #if LowerCase
		if (operation.equalsIgnoreCase("lowercase")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = simpleModifier.lowerCase.make(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing to make LowerCase found.";
			}
			
			return result;
			
		}
		// #endif
		
		// #if RandomNumber
		if (operation.equalsIgnoreCase("randomnumber")) {
			
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
		// #endif
		
		// #if MD5
		if (operation.equalsIgnoreCase("md5")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = hashFunction.MD5.hash(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to hash with MD5.";
			}
			
			return result;
		}
		// #endif
		
		// #if CountSymbols
		if (operation.equalsIgnoreCase("countsymbols")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = statistics.CountSymbols.count(content);
				
				return result;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to calculate the length of.";
			}
		}
		// #endif
		
		result = "Unknown command '" + operation + "'. Type 'help' for a list of all allowed operators.";
		
		return result;
		
	}
	
}
