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
		
		// initialise empty String for result.
		final String result;
		
		// number arguments (without the operation itself)
		final int numberArguments = input.split("\\s+").length - 1;
		
		final String operation;
		final String argumentOne;
		
		final ManageOneArgument manageOne;
		
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
		
		
		if (operation.equalsIgnoreCase("LowerCase")) {
			manageOne = new ManageOneArgument(new simpleModifier.LowerCase(), argumentOne);
			result = manageOne.startCalculating();
			return result;
		}
		
		
		return original(input);
		
	}
	
	
}
