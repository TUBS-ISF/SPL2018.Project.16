package main;

import inputOutput.ReadInput;
import inputOutput.WriteOutput;

public class TextChanger2018 {
	
	/**
	 * The main class of TextChanger2018.
	 * Start this one to start the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Texts.introduce();
		
		while (true) {
			// reads the input.
			String input = ReadInput.read();
			
			// manages the input. Results are printed by the underlaying methods.
			InputManager.manage(input);
			
			// prints an empty line after the result.
			WriteOutput.write("");
			
		}
		
	}
	
}
