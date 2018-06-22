package main;

public class InputManager {
	
	static String manage(String input) {
		
		final String result;
		
		// THIS LINE IS IMPORTANT! Otherwise the program won't compile.
		// reason: otherwise result may be undefined. Remember: this is the last time the method is
		// executed.
		// if something unexpected went wrong. (This code should normally never be reached...)
		result = "Something went wrong if you see this message...";
		
		return result;
		
	}
	
}
