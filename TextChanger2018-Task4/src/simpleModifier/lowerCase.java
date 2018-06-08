package simpleModifier;

public class lowerCase implements interfaces.TwoArguments {
	
	/**
	 * This class makes the input lowercase.
	 * 
	 * @param input
	 *        String which should be made lowercase
	 * @return Input, but everything lowercase.
	 */
	@Override
	public String calculate(String input) {
		
		String inputLower = input.toLowerCase();
		
		return inputLower;
		
	}
}
