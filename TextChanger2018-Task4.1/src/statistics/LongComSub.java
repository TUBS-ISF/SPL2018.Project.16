package statistics;

public class LongComSub implements interfaces.TwoArguments {
	
	/**
	 * This class computes the longest common substring of two given Strings.
	 * If no common substring was found an notification will appear.
	 * 
	 * Note: If serveral LongestCommonSubstring of the same length exist
	 * only the first one will be shown.
	 * 
	 * @param string1
	 *        The first String.
	 * @param string2
	 *        The second String.
	 * @return The longest common substring.
	 */
	@Override
	public String calculate(String string1, String string2) {
		
		final String result;
		
		int startPosition = 0;
		int endPosition = 0;
		
		for (int i = 0; i < string1.length(); i++) {
			
			for (int j = 0; j < string2.length(); j++) {
				
				int currentChar = 0;
				while (string1.charAt(i + currentChar) == string2.charAt(j + currentChar)) {
					
					currentChar++;
					if (i + currentChar >= string1.length()
							|| j + currentChar >= string2.length()) {
						break;
					}
				}
				// replace > with >= to get the last substring (instead the first),
				// if serveral longest common substrings of same length exists
				if (currentChar > endPosition) {
					endPosition = currentChar;
					startPosition = i;
				}
			}
		}
		
		final String longComSub = "Longest common Substring: "
				+ string1.substring(startPosition, (startPosition + endPosition));
		
		// checks for empty result (if no common substring was found.)
		if (longComSub.isEmpty()) {
			result = "<Note: No Common Substring found.>";
		} else {
			result = longComSub;
		}
		
		return result;
	}
}
