package main;
import java.util.Scanner;

public class ReadInput {
	
	static String read() {
		
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		String input = "";
		
		System.out.print("Input: ");
		
		//while (true) {
			
			input = inputScanner.nextLine();
			// inputScanner.close();
			
			return input;
		//}
		
	}
	
}
