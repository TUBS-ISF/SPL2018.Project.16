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
			String input = ReadInput.read();
			
			String result = InputManager.manage(input);
			
			WriteOutput.write(result);
			
		}
		
	}
	
}
