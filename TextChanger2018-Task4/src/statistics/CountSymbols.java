package statistics;

public class CountSymbols implements interfaces.OneArguments {
	
	/**
	 * This class counts the number of symbols of the input.
	 * 
	 * @param input
	 *        The input to be count.
	 * @return Number of symbols in the input.
	 */
	@Override
	public String calculate(String input) {
		
		// calculate the length of the input
		int resultInt = input.length();
		
		// convert to String, since string is needed for output
		String resultString = String.valueOf(resultInt);
		
		// return the result
		return resultString;
	}
}
