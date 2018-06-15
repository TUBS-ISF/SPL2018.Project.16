package main;

import main.PluginManager;

public class inputManager {
	
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
		
		// initialise empty String for result.
		String result = "Error: If you see this message, something went wrong.";
		
		// number arguments (without the operation itself)
		final int numberArguments = input.split("\\s+").length - 1;
		
		final String operation;
		final String argumentOne;
		final String argumentTwo;
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		// saves operation in parameter 'operation'
		// if nothing given raise an error
		if (numberArguments >= 0) {
			operation = input.split("\\s+")[0].toLowerCase();
		} else {
			result = "Error: No input given.";
			return result;
		}
		
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
		
		// Basic operations ***************************************************
		
		if (operation.equalsIgnoreCase("exit") || operation.equalsIgnoreCase("quit")
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
		
		// Extended operations ************************************************
		
		// TODO Use a variant of this to speed up the seach.
		// Don't forget to check for enabled/disabled!
		/*
		if (PluginManager.pluginList().containsKey(operation)) {
			System.out.println("Existiert nicht!");
		}
		*/
		
		// check if the operation exists and is enabled
		if (!(PluginManager.pluginList().containsKey(operation) && pluginEnabled(operation))) {
			result = "Unknown command '" + operation
					+ "'. Type 'help' for a list of all allowed operators.";
			return result;
		}
		
		if (legitOperation(operation, "uppercase")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageOne = new ManageOneArgument(new simpleModifier.upperCase(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (legitOperation(operation, "lowercase")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageOne = new ManageOneArgument(new simpleModifier.lowerCase(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (legitOperation(operation, "randomnumber")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageOne = new ManageOneArgument(new randomGenerator.RandomNumber(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (legitOperation(operation, "md5")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageOne = new ManageOneArgument(new hashFunction.MD5(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (legitOperation(operation, "countsymbols")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageOne = new ManageOneArgument(new statistics.CountSymbols(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (legitOperation(operation, "rot13")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageOne = new ManageOneArgument(new simpleModifier.ROT13(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (legitOperation(operation, "aes")) {
			if (!legitArgumentNumber(operation, numberArguments)) {
				return result = "";
			}
			manageTwo = new ManageTwoArguments(new enDeCrypt.AES(), argumentOne, argumentTwo);
			result = manageTwo.startCalculating();
			return result;
		}
		
		// if operation not found or not enabled
		result = "Unknown command '" + operation
				+ "'. Type 'help' for a list of all allowed operators.";
		
		return result;
		
	}
	
	/**
	 * Generates the error-message for the wrong number of given arguments
	 * Note: numberIs has to be decreased by one. Otherwise the operation istelf
	 * is counted, too.
	 * 
	 * @param operation
	 *        The name of the desired operation
	 * @param numberIs
	 *        The number of the given arguments
	 * @param numberShould
	 *        The number of arguments needed
	 * @return The String with the matching error-message
	 */
	public static String notEnoughArguments(String operation, int numberIs, int numberShould) {
		
		String message = "Error: " + operation + ": Wrong number of arguments given.\n" + "Given: "
				+ (numberIs) + " Should: " + numberShould;
		return message;
	}
	
	/**
	 * This method checks if an given operation is legit.
	 * It is legit, if it is in the list *and* enabled.
	 * 
	 * @param operation
	 *        The given operation.
	 * @param toCheck
	 *        The operation currently to check.
	 * @return Is it legit or not? (Boolean)
	 */
	public static boolean legitOperation(String operation, String toCheck) {
		
		// if the operation exists
		if (operation.equalsIgnoreCase(toCheck)) {
			
			// if the operation is enabled
			if (PluginManager.pluginList().get(operation).get(0).equalsIgnoreCase("1")) {
				
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	/**
	 * This method checks if the number of given arguments is correct.
	 * It compares the number of given arguments with the umber of required
	 * arguments.
	 * 
	 * If the number is not correct descripe the problem in the output.
	 * 
	 * @param operation
	 *        Name of the given operation to check.
	 * @param numberArguments
	 *        Given number of arguments.
	 * @return Is the number correct or not? (boolean.)
	 */
	public static boolean legitArgumentNumber(String operation, int numberArgumentsGiven) {
		
		int argumentNumberRequired = Integer
				.parseInt(PluginManager.pluginList().get(operation).get(1));
		
		// if operation has correct argument number
		if (numberArgumentsGiven == argumentNumberRequired) {
			
			return true;
			
		} else {
			// Write error if wrong argument number
			String message = "Error: " + operation + ": Wrong number of arguments given.\n"
					+ "Given: " + (numberArgumentsGiven) + " Should: "
					+ PluginManager.pluginList().get(operation).get(1);
			WriteOutput.write(message);
			return false;
		}
		
	}
	
	/**
	 * Checks if an operation is enabled in the PluginList
	 * 
	 * @param operation
	 *        Name of the desirec operation
	 * @return Is it enabled or not?
	 */
	public static boolean pluginEnabled(String operation) {
		if (PluginManager.pluginList().get(operation).get(0).equalsIgnoreCase("1")) {
			return true;
		} else {
			return false;
		}
	}
	
}
