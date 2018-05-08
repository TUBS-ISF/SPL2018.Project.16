package main;

public class Help {
	
	/*
	 * private static void helpFormat(String name, String description, String usage)
	 * {
	 * 
	 * int nameLength = name.length();
	 * 
	 * String tabs2 = "\t\t";
	 * 
	 * WriteOutput.write(name + "\t" + description); WriteOutput.write(tabs2 +
	 * "Usage: " + usage); WriteOutput.write(""); }
	 */
	
	public static void help() {
		WriteOutput.write("This is an overview of all possible arguments:");
		WriteOutput.write("Note: 'input' stands for any input.");
		WriteOutput.write("Note: command argument isn't case-sensitive, but 'input' is.");
		WriteOutput.write(
				"NOTE: Currently it is not possible to use input containing whitespaces. Using quotation marks doesn't help.");
		WriteOutput.write("*************");
		
		WriteOutput.write("help: Shows this page ;).");
		WriteOutput.write("license: Shows the license (GPLv3).");
		WriteOutput.write("exit/quit: closes the program.");
		WriteOutput.write("");
		
		if (Available.ROT13()) {
			WriteOutput.write("ROT13:" + "Makes an ROT13-modification of the given input.");
			WriteOutput.write("\t" + "Usage: \"ROT13 'input'\"");
			WriteOutput.write("");
			
			// helpFormat("ROT13", "Makes an ROT13-modification of the given input.",
			// "\"ROT13 'input'\"");
		}
		
		if (Available.UpperCase()) {
			WriteOutput.write("UpperCase: Makes all letters UPPERCASE.");
			WriteOutput.write("\t" + "Usage: \"UpperCase 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.LowerCase()) {
			WriteOutput.write("LowerCase: Makes all letters lowercase.");
			WriteOutput.write("\t" + "Usage \"LowerCase 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.Reverse()) {
			WriteOutput.write("Reverse: Reverses the input. For example: 'example' => 'elpmaxe'.");
			WriteOutput.write("\t" + "Usage \"Reverse 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.AES()) {
			WriteOutput.write("AES: Encrypt/Decrypt the input with AES using the given password.");
			WriteOutput.write("\t" + "Usage \"AES 'password' 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.DES()) {
			WriteOutput.write("DES: Encrypt/Decrypt the input with DES using the given password.");
			WriteOutput.write("\t" + "Usage \"DES 'password' 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.IDEA()) {
			WriteOutput.write("IDEA: Encrypt/Decrypt the input with IDEA using the given password.");
			WriteOutput.write("\t" + "Usage \"IDEA 'password' 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.RandomNumber()) {
			WriteOutput.write("RandomNumber: Calculates an random number of given legth.");
			WriteOutput.write("\t" + "Usage \"RandomNumber 'length'\"");
			WriteOutput.write("");
		}
		
		if (Available.RandomLetters()) {
			WriteOutput.write("RandomLetters: Calculates an random string (only letters) of given legth.");
			WriteOutput.write("\t" + "Usage \"RandomLetters 'length'\"");
			WriteOutput.write("");
		}
		
		if (Available.RandomString()) {
			WriteOutput.write("RandomString: Calculates an random string (numbers and letters) of given legth.");
			WriteOutput.write("\t" + "Usage \"RandomString 'length'\"");
			WriteOutput.write("");
		}
		
		if (Available.SHA256()) {
			WriteOutput.write("SHA256: Calculates the hash value of the input with the SHA256 algorithm.");
			WriteOutput.write("\t" + "Usage \"SHA256 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.MD5()) {
			WriteOutput.write("MD5: Calculates the hash value of the input with the MD5 algorithm.");
			WriteOutput.write("\t" + "Usage \"MD5 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.CountSymbols()) {
			WriteOutput.write("CountSymbols: Counts the symbols of the input.");
			WriteOutput.write("\t" + "Usage \"CountSymbols 'input'\"");
			WriteOutput.write("");
		}
		
		if (Available.CountSymbolAppearance()) {
			WriteOutput.write("CountSymbolAppearance: Counts for each symbol of the input how often it appears.");
			WriteOutput.write("\t" + "Usage \"CountSymbolAppearance 'input'\"");
			WriteOutput.write("");
		}
		
		// WriteOutput.write("GUI: turns the GUI on/off.");
		// WriteOutput.write("Usage \"GUI boolean\"");
		
		/*
		 * // templates.
		 * 
		 * WriteOutput.write("COMMAND: ");
		 * WriteOutput.write("Usage \"COMMAND 'input'\"");
		 * 
		 * 
		 * WriteOutput.write("");
		 */
		
	}
	
}
