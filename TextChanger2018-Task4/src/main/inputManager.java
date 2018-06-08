package main;

public class inputManager {
	
	/**
	 * Reads the parameter on the given position and returns it.
	 * 
	 * @param input
	 *        Input String
	 * @param number
	 *        The position of the desired parameter.
	 * @return The parameter on the desired position.
	 */
	static String readParameter(String input, int number) {
		
		String parameter = input.split("\\s+")[number];
		
		return parameter;
		
	}
	
	/**
	 * Counts the number of Arhuments in the given input
	 * 
	 * @param input
	 *        The given input
	 * @return The number of Arguments in the given input.
	 */
	static int countInputArguments(String input) {
		
		int numberOfArguments = input.split("\\s+").length;
		
		return numberOfArguments;
		
	}
	
	/**
	 * This method (a *very* inportant method!) reads the input of the given
	 * String (read from the console), extracts the first parameter which
	 * describes the desired action and executes it.
	 * The result (a String) is returned.
	 * 
	 * @param input
	 *        The String read from the console.
	 * @return The calculated result.
	 */
	static String manage(String input) {
		
		int numberArguments = countInputArguments(input);
		
		// initialise empty String for result.
		String result = "Error: If you see this message, something went wrong.";
		
		// saves operation in parameter 'operation'
		String operation = readParameter(input, 0);
		
		if (operation.equalsIgnoreCase("exit")
				|| operation.equalsIgnoreCase("quit")
				|| operation.equalsIgnoreCase("q")) {
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
		
		if (operation.equalsIgnoreCase("uppercase")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = simpleModifier.upperCase.calculate(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing to make UpperCase found.";
			}
			
			return result;
		}
		
		if (operation.equalsIgnoreCase("lowercase")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = simpleModifier.lowerCase.calculate(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing to make LowerCase found.";
			}
			
			return result;
			
		}
		
		if (operation.equalsIgnoreCase("randomnumber")) {
			
			try {
				String lengthStr = readParameter(input, 1);
				
				try {
					int lengthInt = Integer.parseInt(lengthStr);
					
					result = randomGenerator.RandomNumber.calculate(lengthInt);
					
				} catch (NumberFormatException e) {
					result = "Error: Wrong Argument: Length of random number was not an number. (Given: \""
							+ lengthStr + "\")";
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Length of random number not found.";
			}
			
			return result;
			
		}
		
		if (operation.equalsIgnoreCase("md5")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = hashFunction.MD5.calculate(content);
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to hash with MD5.";
			}
			
			return result;
		}
		
		if (operation.equalsIgnoreCase("countsymbols")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = statistics.CountSymbols.calculate(content);
				
				return result;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to calculate the length of.";
			}
		}
		
		if (operation.equalsIgnoreCase("rot13")) {
			
			try {
				String content = readParameter(input, 1);
				
				result = enDeCrypt.ROT13.calculate(content);
				
				return result;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				result = "Error: Missing Argument: Nothing given to encrypt/decrypt to/from ROT13.";
			}
			
		}
		
		result = "Unknown command '" + operation
				+ "'. Type 'help' for a list of all allowed operators.";
		
		return result;
		
	}
	
}
