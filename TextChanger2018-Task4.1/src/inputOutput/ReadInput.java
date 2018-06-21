package inputOutput;

import java.util.Scanner;

public class ReadInput {
	
	/**
	 * Reads the input from the console and returns the given String.
	 * 
	 * @return The String given on the console.
	 */
	public static String read() {
		
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		String input = "";
		
		System.out.print("Input: ");
		
		input = inputScanner.nextLine();
		
		return input;
		
	}
	
}
