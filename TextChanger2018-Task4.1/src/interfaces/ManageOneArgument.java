package interfaces;

public class ManageOneArgument {
	
	private OneArgument mode = null;
	private String argumentOne = null;
	
	// constructor for class
	public ManageOneArgument(OneArgument mode, String argumentOne) {
		this.mode = mode;
		this.argumentOne = argumentOne;
	}
	
	// called by this class to calculate and get the result from the plugin.
	public String startCalculating() {
		
		String result = mode.calculate(argumentOne);
		return result;
	}
	
}
