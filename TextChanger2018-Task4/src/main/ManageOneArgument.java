package main;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import interfaces.OneArguments;
import simpleModifier.lowerCase;

public class ManageOneArgument {
	
	private OneArguments mode = null;
	private String argumentOne = "";
	
	public ManageOneArgument(OneArguments mode, String argumentOne) {
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
		
		ManageOneArgument manageTwo = null;
		String result = null;
		
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
		
		return result;
	}
	
}
