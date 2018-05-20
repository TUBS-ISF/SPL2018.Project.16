package main;

public class Texts {
	
	static void introduce() {
		
		String text1 = "Welcome to TextChanger2018!";
		String text2 = "For a list of all possible functions type 'help'. For Information about the license type 'license'.";
		String text3 = "To exit the program type 'exit' or 'quit' or 'q'.";
		
		WriteOutput.write(text1);
		WriteOutput.write(text2);
		WriteOutput.write(text3);
		
	}
	
	static String license() {
		
		final String seperator = System.getProperty("line.separator");
		
		String license = "This program is free software: you can redistribute it and/or modify" + seperator
				+ "it under the terms of the GNU General Public License as published by" + seperator
				+ "the Free Software Foundation, either version 3 of the License, or" + seperator
				+ "(at your option) any later version." + seperator + seperator
				
				+ "This program is distributed in the hope that it will be useful," + seperator
				+ "but WITHOUT ANY WARRANTY; without even the implied warranty of" + seperator
				+ "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the" + seperator
				+ "GNU General Public License for more details." + seperator + seperator
				
				+ "You should have received a copy of the GNU General Public License" + seperator
				+ "along with this program.  If not, see <https://www.gnu.org/licenses/>.";
		
		return license;
	}
	
	public static void help() {
		WriteOutput.write("This is an overview of all possible arguments:");
		WriteOutput.write("Note: 'input' stands for any input.");
		WriteOutput.write("Note: command argument isn't case-sensitive, but 'input' is.");
		WriteOutput.write(
				"NOTE: Currently it is not possible to use input containing whitespaces. Using quotation marks doesn't help.");
		WriteOutput.write("*************");
		
		WriteOutput.write("help: Shows this page ;).");
		WriteOutput.write("license: Shows the license (GPLv3).");
		WriteOutput.write("exit/quit/q: closes the program.");
		WriteOutput.write("");
		
		// #if ROT13
		WriteOutput.write("ROT13: Makes an ROT13-modification of the given input.");
		WriteOutput.write("\t" + "Usage: \"ROT13 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// helpFormat("ROT13", "Makes an ROT13-modification of the given input.",
		// "\"ROT13 'input'\"");
		
		// #if UpperCase
		WriteOutput.write("UpperCase: Makes all letters UPPERCASE.");
		WriteOutput.write("\t" + "Usage: \"UpperCase 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if LowerCase
		WriteOutput.write("LowerCase: Makes all letters lowercase.");
		WriteOutput.write("\t" + "Usage \"LowerCase 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if Reverse
		WriteOutput.write("Reverse: Reverses the input. For example: 'example' => 'elpmaxe'.");
		WriteOutput.write("\t" + "Usage \"Reverse 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if AES
		WriteOutput.write("AES: Encrypt/Decrypt the input with AES using the given password.");
		WriteOutput.write("\t" + "Usage \"AES 'password' 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if DES
		WriteOutput.write("DES: Encrypt/Decrypt the input with DES using the given password.");
		WriteOutput.write("\t" + "Usage \"DES 'password' 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if IDEA
		WriteOutput.write("IDEA: Encrypt/Decrypt the input with IDEA using the given password.");
		WriteOutput.write("\t" + "Usage \"IDEA 'password' 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if RandomNumber
		WriteOutput.write("RandomNumber: Calculates an random number of given legth.");
		WriteOutput.write("\t" + "Usage \"RandomNumber 'length'\"");
		WriteOutput.write("");
		// #endif
		
		// #if RandomLetters
		WriteOutput.write("RandomLetters: Calculates an random string (only letters) of given legth.");
		WriteOutput.write("\t" + "Usage \"RandomLetters 'length'\"");
		WriteOutput.write("");
		// #endif
		
		// #if RandomString
		WriteOutput.write("RandomString: Calculates an random string (numbers and letters) of given legth.");
		WriteOutput.write("\t" + "Usage \"RandomString 'length'\"");
		WriteOutput.write("");
		// #endif
		
		// #if SHA256
		WriteOutput.write("SHA256: Calculates the hash value of the input with the SHA256 algorithm.");
		WriteOutput.write("\t" + "Usage \"SHA256 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if MD5
		WriteOutput.write("MD5: Calculates the hash value of the input with the MD5 algorithm.");
		WriteOutput.write("\t" + "Usage \"MD5 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if CountSymbols
		WriteOutput.write("CountSymbols: Counts the symbols of the input.");
		WriteOutput.write("\t" + "Usage \"CountSymbols 'input'\"");
		WriteOutput.write("");
		// #endif
		
		// #if CountSymbolAppearence
		// @ WriteOutput.write("CountSymbolAppearance: Counts for each symbol of the
		// @ // input how often it appears.");
		// @ WriteOutput.write("\t" + "Usage \"CountSymbolAppearance 'input'\"");
		// @ WriteOutput.write("");
		// #endif
		
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
