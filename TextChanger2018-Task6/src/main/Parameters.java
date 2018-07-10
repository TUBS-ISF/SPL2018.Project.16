package main;

public class Parameters {
	
	private static int numberArguments;
	private static String operation;
	private static String argumentOne;
	private static String argumentTwo;
	
	/**
	 * This class is used to set the parameters like the desired operation
	 * and the arguments.
	 * 
	 * @param input
	 *        The Input.
	 */
	public static void set(String input) {
		
		Parameters.numberArguments = input.split("\\s+").length - 1;
		
		Parameters.operation = input.split("\\s+")[0].toLowerCase();
		
		if (Parameters.numberArguments >= 1) {
			Parameters.argumentOne = input.split("\\s+")[1];
		}
		
		if (Parameters.numberArguments >= 2) {
			Parameters.argumentTwo = input.split("\\s+")[2];
		}
		
	}
	
	public static int getNumberArguments() {
		return Parameters.numberArguments;
	}
	
	public static String getOperation() {
		return Parameters.operation;
	}
	
	public static String getArgumentOne() {
		return Parameters.argumentOne;
	}
	
	public static String getArgumentTwo() {
		return Parameters.argumentTwo;
	}
	
}
