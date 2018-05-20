package enDeCrypt;

public class ROT13 {
	/**
	 * This classgets an String and calculates the ROT13 result.
	 * 
	 * @param input
	 *        The String to be processed.
	 * @return The result.
	 */
	public static String calculate(String input) {
		
		String result = "";
		
		for (int charPos = 0; charPos < input.length(); charPos++) {
			
			char inputChar = input.charAt(charPos);
			
			if (inputChar >= 'a' && inputChar <= 'm') {
				inputChar += 13;
			} else if (inputChar >= 'A' && inputChar <= 'M') {
				inputChar += 13;
			} else if (inputChar >= 'n' && inputChar <= 'z') {
				inputChar -= 13;
			} else if (inputChar >= 'N' && inputChar <= 'Z') {
				inputChar -= 13;
			}
			
			result = result.concat(Character.toString(inputChar));
		}
		
		return result;
		
	}
	
}
