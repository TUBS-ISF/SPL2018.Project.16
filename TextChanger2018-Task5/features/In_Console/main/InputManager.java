package main;

import java.util.Arrays;

import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.PluginManager;

public class InputManager {
	
	/**
	 * This method (a *very* inportant method!) reads the input of the given
	 * String (read from the console), extracts the first parameter which
	 * describes the desired action and executes  it.
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
		
		// saves operation in parameter 'operation'
		// raise error if no input given
		if (numberArguments >= 0) {
			operation = input.split("\\s+")[0].toLowerCase();
		} else {
			result = "Error: No input given.";
			return result;
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
		
		/*
		 * The operations are included using the other features.
		 */
		
		// if something unexpected went wrong. (This code should normally never be reached...)
		result = "Something went wrong if you see this message...";
		
		return original(input);
		
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
	// Keywords for enabled/disbaled can be changed here.
	private static boolean pluginEnabled(String operation) {
		
		final String pluginStatus = PluginManager.pluginList().get(operation).get(0);
		
		final String[] enabled = new String[] { "1", "true", "enabled", "positive" };
		final String[] disabled = new String[] { "0", "false", "disabled", "negative" };
		
		if (Arrays.asList(enabled).contains(pluginStatus)) {
			return true;
		} else if (Arrays.asList(disabled).contains(pluginStatus)) {
			return false;
		} else {
			WriteOutput.write("Critical error: illegal Enabled/Disabled status for operation \""
					+ operation + "\".");
			WriteOutput.write("Given status: \"" + pluginStatus + "\"");
			WriteOutput.write("Allowed for enabled: " + Arrays.toString(enabled));
			WriteOutput.write("Allowed for disabled: " + Arrays.toString(disabled));
			return false;
		}
		
	}
	
	// Check if the correct number of arguments is given
	private static boolean pluginArgumentNumber(String operation, int numberArgumentsGiven) {
		
		final String argumentNumberRequiredStr = PluginManager.pluginList().get(operation).get(1);
		final int argumentNumberRequired;
		
		try {
			// convert to int, since originally stored as String.
			argumentNumberRequired = Integer.parseInt(argumentNumberRequiredStr);
		} catch (NumberFormatException e) {
			// Catch error if not a number
			WriteOutput.write("Error: Illegal value for 'number of Arguments'.");
			WriteOutput.write("Given: \"" + argumentNumberRequiredStr + "\"");
			WriteOutput.write("Expected: An number like \"1\" for one argument. "
					+ "(Don't forget the quotation marks.)");
			return false;
		}
		
		// if operation has correct argument number
		if (numberArgumentsGiven == argumentNumberRequired) {
			return true;
		} else {
			return false;
		}
	}
	
}
