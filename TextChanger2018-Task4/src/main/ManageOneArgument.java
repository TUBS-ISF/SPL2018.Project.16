package main;

import interfaces.OneArgument;

public class ManageOneArgument {
	
	private OneArgument mode = null;
	private String argumentOne = null;
	
	public ManageOneArgument(OneArgument mode, String argumentOne) {
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
		
		ManageOneArgument manageOne = null;
		String result = null;
		
		if (argumentOne.equalsIgnoreCase("uppercase")) {
			manageOne = new ManageOneArgument(new simpleModifier.upperCase(),
					argumentTwo);
			result = manageOne.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("lowercase")) {
			manageOne = new ManageOneArgument(new simpleModifier.lowerCase(),
					argumentTwo);
			result = manageOne.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("randomnumber")) {
			manageOne = new ManageOneArgument(
					new randomGenerator.RandomNumber(), argumentTwo);
			result = manageOne.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("md5")) {
			manageOne = new ManageOneArgument(new hashFunction.MD5(),
					argumentTwo);
			result = manageOne.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("countsymbols")) {
			manageOne = new ManageOneArgument(new statistics.CountSymbols(),
					argumentTwo);
			result = manageOne.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("rot13")) {
			manageOne = new ManageOneArgument(new enDeCrypt.ROT13(),
					argumentTwo);
			result = manageOne.startCalculating();
		}
		
		// if no valid command
		if (manageOne == null || result == null) {
			result = "Unknown command '" + argumentOne
					+ "'. Type 'help' for a list of all allowed operators.";
		}
		
		return result;
	}
	
}
