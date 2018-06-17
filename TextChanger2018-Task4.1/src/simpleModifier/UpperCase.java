package simpleModifier;

public class UpperCase implements interfaces.OneArgument {
	
	/**
	 * This class makes the input lowercase.
	 * 
	 * @param input
	 *        String which should be made lowercase
	 * @return Input, but everything lowercase.
	 */
	@Override
	public String calculate(String input) {
		
		String inputUpper = input.toUpperCase();
		
		return inputUpper;
		
	}
	
}
