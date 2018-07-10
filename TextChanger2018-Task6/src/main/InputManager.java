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
	 * describes the desired action and executes it.
	 * The result (a String) is returned.
	 * 
	 * @param input
	 *        The String read from the console.
	 * @return The calculated result.
	 */
	static String manage(String input) {
		
		// Extract data from input and put it in the variables
		Parameters.set(input);
		int numberArguments = Parameters.getNumberArguments();
		String operation = Parameters.getOperation();
		String argumentOne = Parameters.getArgumentOne();
		String argumentTwo = Parameters.getArgumentTwo();
		
		// initialise empty String for result.
		final String result;
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		// Basic operations ***************************************************
		
		if (operation.equals("exit") || operation.equals("quit") || operation.equals("q")) {
			WriteOutput.write("Exit Program.");
			System.exit(0);
		}
		
		if (operation.equals("license")) {
			result = Texts.license();
			return result;
		}
		
		if (operation.equals("help")) {
			Texts.help();
			result = "";
			return result;
		}
		
		// check for legit operation ******************************************
		// (Plugin must exist, be enabled, have correct number arguments)
		
		// raise error if no arguments are given
		// Important: This must be *below* the entries without any arguments!
		if (numberArguments == 0) {
			return "Error: No arguments given.";
		}
		
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
		
		final boolean startChecksHere = startPlugins(input);
		
		if (Parameters.getFeatureUsed()) {
			// System.out.println("Feature used.");
			Parameters.setFeatureUsedFalse();
			return "";
		}
		
		// if something unexpected went wrong. (This code should normally never be reached...)
		// result = "Something went wrong if you see this message...";
		
		// This can only be reached if an feature exists but had not been used.
		// This in turn can only happen if it is disabled.
		result = "Error: Selected Feature exists, but is disabled.";
		
		return result;
		
	}
	
	// This does nothing. It only exists to create an pointcut.
	private static boolean startPlugins(String test) {
		return true;
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
