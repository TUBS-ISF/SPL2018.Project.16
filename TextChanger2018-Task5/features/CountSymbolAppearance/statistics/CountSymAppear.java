package statistics;

import java.util.HashMap;
import java.util.Map;

public class CountSymAppear implements interfaces.OneArgument {
	
	/**
	 * This class counts how often each symbol appears in a given String.
	 * 
	 * @param input
	 *        Input to analyse.
	 * @return List of all Symbols with number of appearences.
	 */
	@Override
	public String calculate(String input) {
		
		final String result;
		
		final int inputLength = input.length();
		
		Map<Character, Integer> numberCharacters = new HashMap<Character, Integer>(
				Math.min(inputLength, 26));
		
		// for all chars of the input
		for (int i = 0; i < inputLength; ++i) {
			
			char charAt = input.charAt(i);
			
			// if char is not in result add it
			if (!numberCharacters.containsKey(charAt)) {
				
				numberCharacters.put(charAt, 1);
				
			} else {
				// otherwise increase appearance number by one
				numberCharacters.put(charAt, numberCharacters.get(charAt) + 1);
			}
		}
		
		result = numberCharacters.toString();
		
		return result;
	}
	
}
