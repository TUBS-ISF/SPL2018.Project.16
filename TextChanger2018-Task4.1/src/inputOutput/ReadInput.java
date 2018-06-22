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
		final Scanner inputScanner = new Scanner(System.in);
		
		// important: Use NOT "println" here.
		System.out.print("Input: ");
		
		final String input = inputScanner.nextLine();
		
		return input;
	}
	
}
