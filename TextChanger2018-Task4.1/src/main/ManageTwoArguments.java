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
	
}
