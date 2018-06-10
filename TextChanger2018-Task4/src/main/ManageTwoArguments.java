package main;

import interfaces.TwoArguments;

public class ManageTwoArguments {
	
	private TwoArguments mode = null;
	private String argumentOne = null;
	private String argumentTwo = null;
	
	public ManageTwoArguments(TwoArguments mode, String argumentOne,
			String argumentTwo) {
		this.mode = mode;
		this.argumentOne = argumentOne;
		this.argumentTwo = argumentTwo;
	}
	
	public String startCalculating() {
		
		String result = mode.calculate(argumentOne, argumentTwo);
		return result;
	}
	
	// TODO: Make an *real* manager who can parse the command directly
	public static String start(String argumentOne, String argumentTwo,
			String argumentThree) {
		String result = uglyManager(argumentOne, argumentTwo, argumentThree);
		
		return result;
	}
	
	private static String uglyManager(String argumentOne, String argumentTwo,
			String argumentThree) {
		
		ManageTwoArguments manageTwo = null;
		String result = null;
		
		if (argumentOne.equalsIgnoreCase("aes")) {
			manageTwo = new ManageTwoArguments(new enDeCrypt.AES(), argumentTwo,
					argumentThree);
			result = manageTwo.startCalculating();
		}
		
		/*
		if (argumentOne.equalsIgnoreCase("uppercase")) {
			manageTwo = new ManageOneArgument(new simpleModifier.upperCase(),
					argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("lowercase")) {
			manageTwo = new ManageOneArgument(new simpleModifier.lowerCase(),
					argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("randomnumber")) {
			manageTwo = new ManageOneArgument(
					new randomGenerator.RandomNumber(), argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("md5")) {
			manageTwo = new ManageOneArgument(new hashFunction.MD5(),
					argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("countsymbols")) {
			manageTwo = new ManageOneArgument(new statistics.CountSymbols(),
					argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		if (argumentOne.equalsIgnoreCase("rot13")) {
			manageTwo = new ManageOneArgument(new enDeCrypt.ROT13(),
					argumentTwo);
			result = manageTwo.startCalculating();
		}
		
		// if no valid command
		if (manageTwo == null || result == null) {
			result = "Unknown command '" + argumentOne
					+ "'. Type 'help' for a list of all allowed operators.";
		}
		*/
		
		return result;
	}
	
}
