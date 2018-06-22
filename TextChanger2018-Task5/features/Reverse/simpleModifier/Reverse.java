package simpleModifier;

public class Reverse implements interfaces.OneArgument {
	
	/**
	 * This class gets an String for input and reverses it.
	 * For example, "example" will become "elpmaxe".
	 * 
	 * @param input
	 *        The String to inverse.
	 * @return The inversed String.
	 */
	@Override
	public String calculate(String input) {
		
		final String result = new StringBuilder(input).reverse().toString();
		
		return result;
	}
	
}
