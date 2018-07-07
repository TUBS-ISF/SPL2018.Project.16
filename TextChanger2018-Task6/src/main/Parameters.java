package main;

public class Parameters {
	
	private String operation;
	private String argumentOne;
	private String argumentTwo;
	
	public Parameters(String input) {
		
		final int numberArguments = input.split("\\s+").length - 1;
		
		this.operation = input.split("\\s+")[0].toLowerCase();
		
		if (numberArguments >= 1) {
			this.argumentOne = input.split("\\s+")[1];
		}
		
		if (numberArguments >= 2) {
			argumentTwo = input.split("\\s+")[2];
		}
		
	}
	
	public String getOperation() {
		return this.operation;
	}
	
	public String getArgumentOne() {
		return this.argumentOne;
	}
	
	public String getArgumentTwo() {
		return this.argumentTwo;
	}
	
}
