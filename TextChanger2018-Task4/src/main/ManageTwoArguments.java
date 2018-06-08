package main;

import interfaces.TwoArguments;
import simpleModifier.lowerCase;

public class ManageTwoArguments {
	
	private TwoArguments mode = null;
	private String argumentOne = "";
	
	public ManageTwoArguments(TwoArguments mode, String argumentOne) {
		this.mode = mode;
		this.argumentOne = argumentOne;
	}
	
	public String startCalculating() {
		
		String result = mode.calculate(argumentOne);
		return result;
	}
	
	// TODO: Make an *real* manager who can parse the command directly
	public static String start(String argumentOne, String argumentTwo) {
		String result = uglyManager(argumentOne, argumentTwo);
		
		return result;
	}
	
	private static String uglyManager(String argumentOne, String argumentTwo) {
		
		ManageTwoArguments manageTwo = null;
		String result = null;
		
		if (argumentOne.equalsIgnoreCase("lowercase")) {
			manageTwo = new ManageTwoArguments(new simpleModifier.lowerCase(),
					argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		// if no valid command
		if (manageTwo == null || result == null) {
			result = "Unknown command '" + argumentOne
					+ "'. Type 'help' for a list of all allowed operators.";
		}
		
		return result;
	}
	
}
