package main;

import main.PluginManager;

public class InputManager {
	
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
		final String result;
		
		// number arguments (without the operation itself)
		final int numberArguments = input.split("\\s+").length - 1;
		
		final String operation;
		final String argumentOne;
		final String argumentTwo;
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		// saves operation in parameter 'operation'
		// raise error if no input given
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
		
		// check for legit operation ******************************************
		// (Plugin must exist, be enabled, have correct number arguments)
		
		// check if the operation exists and is enabled
		// otherwise return "Unknown command"
		if (!(pluginExists(operation) && pluginEnabled(operation))) {
			result = "Unknown command '" + operation
					+ "'. Type 'help' for a list of all allowed operators.";
			return result;
		}
		
		// check if the correct number of arguments is given
		// otherwise return an error message
		if (!(pluginArgumentNumber(operation, numberArguments))) {
			result = "Error: " + operation + ": Wrong number of arguments given.\n"
					+ "Arguments given: " + (numberArguments) + " Arguments required: "
					+ PluginManager.pluginList().get(operation).get(1);
			return result;
		}
		
		// Extended operations ************************************************
		// Note: since the legitimitation of the operation is already checked
		// above it's not checked again.
		
		if (operation.equalsIgnoreCase("UpperCase")) {
			manageOne = new ManageOneArgument(new simpleModifier.upperCase(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (operation.equalsIgnoreCase("Lowercase")) {
			manageOne = new ManageOneArgument(new simpleModifier.lowerCase(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (operation.equalsIgnoreCase("RandomNumber")) {
			manageOne = new ManageOneArgument(new randomGenerator.RandomNumber(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (operation.equalsIgnoreCase("MD5")) {
			manageOne = new ManageOneArgument(new hashFunction.MD5(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (operation.equalsIgnoreCase("CountSymbols")) {
			manageOne = new ManageOneArgument(new statistics.CountSymbols(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (operation.equalsIgnoreCase("ROT13")) {
			manageOne = new ManageOneArgument(new simpleModifier.ROT13(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		if (operation.equalsIgnoreCase("AES")) {
			manageTwo = new ManageTwoArguments(new enDeCrypt.AES(), argumentOne, argumentTwo);
			result = manageTwo.startCalculating();
			return result;
		}
		
		// if operation not found or not enabled
		result = "Unknown command '" + operation
				+ "'. Type 'help' for a list of all allowed operators.";
		
		return result;
		
	}
	
	// Check if plugin exists
	private static boolean pluginExists(String operation) {
		
		if (PluginManager.pluginList().containsKey(operation)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Check if plugin is enabled
	private static boolean pluginEnabled(String operation) {
		
		if (PluginManager.pluginList().get(operation).get(0).equalsIgnoreCase("1")) {
			return true;
		} else {
			return false;
		}
	}
	
	// Check if the correct number of arguments is given
	private static boolean pluginArgumentNumber(String operation, int numberArgumentsGiven) {
		
		String argumentNumberRequiredStr = PluginManager.pluginList().get(operation).get(1);
		
		// convert to int, since originally stored as String.
		int argumentNumberRequired = Integer.parseInt(argumentNumberRequiredStr);
		
		// if operation has correct argument number
		if (numberArgumentsGiven == argumentNumberRequired) {
			return true;
		} else {
			return false;
		}
	}
	
}
