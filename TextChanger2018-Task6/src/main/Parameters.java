package main;

public class Parameters {
	
	private String operation;
	private String argumentOne;
	private String argumentTwo;
	private static boolean featureUsed;
	
	/**
	 * This class is used to access the parameters in the aspects,
	 * since the usual way doesn't work.
	 * 
	 * @param input
	 *        The Input.
	 */
	public Parameters(String input) {
		
		final int numberArguments = input.split("\\s+").length - 1;
		
		this.operation = input.split("\\s+")[0].toLowerCase();
		
		if (numberArguments >= 1) {
			this.argumentOne = input.split("\\s+")[1];
		}
		
		if (numberArguments >= 2) {
			argumentTwo = input.split("\\s+")[2];
		}
		
		Parameters.featureUsed = false;
		
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
	
	public static boolean getFeatureUsed() {
		return Parameters.featureUsed;
	}
	
	public static void setFeatureUsedTrue() {
		Parameters.featureUsed = true;
	}
	
	public static void setFeatureUsedFalse() {
		Parameters.featureUsed = false;
	}
	
}
