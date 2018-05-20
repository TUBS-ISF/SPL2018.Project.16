package main;

public class TextChanger2018 {
	
	public static void main(String[] args) {
		
		Texts.introduce();
		
		while (true) {
			String input = ReadInput.read();
			
			String result = inputManager.manage(input);
			
			WriteOutput.write(result);
			
		}
		
	}
	
}
