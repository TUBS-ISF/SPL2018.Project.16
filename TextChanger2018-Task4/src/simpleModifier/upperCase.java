// #if UpperCase
package simpleModifier;

public class upperCase implements interfaces.OneArgument {
	
	/**
	 * This class makes the input lowercase.
	 * 
	 * @param input
	 *        String which should be made lowercase
	 * @return Input, but everything lowercase.
	 */
	public static String make(String input) {
		
		String inputUpper = input.toUpperCase();
		
		return inputUpper;
		
	}
	
	@Override
	public String OneArgumentOne(String input) {
		
		return make(input);
	}
}
// #endif
