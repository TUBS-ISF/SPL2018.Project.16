package main;

import properties.PropertyManager;

/*
 * Possible properties:
 * 
 * ROT13
 * UpperCase
 * LowerCase
 * Reverse
 * AES
 * DES
 * IDEA
 * In_Console
 * In_Textfield
 * Out_Console
 * Out_Textfield
 * RandomNumbers
 * RandomLetters
 * RandomString
 * SHA256
 * MD5
 * CountSymbols
 * CountSymbolAppearance
 * GUI
 */

public class Available {
	
	public static boolean ROT13() {
		
		return PropertyManager.getProperty("ROT13");
		
	}
	
	public static boolean UpperCase() {
		
		return PropertyManager.getProperty("UpperCase");
		
	}
	
	public static boolean LowerCase() {
		
		return PropertyManager.getProperty("LowerCase");
		
	}
	
	public static boolean Reverse() {
		
		return PropertyManager.getProperty("Reverse");
		
	}
	
	public static boolean AES() {
		
		return PropertyManager.getProperty("AES");
		
	}
	
	public static boolean DES() {
		
		return PropertyManager.getProperty("DES");
		
	}
	
	public static boolean IDEA() {
		
		return PropertyManager.getProperty("IDEA");
		
	}
	
	public static boolean In_Console() {
		
		return PropertyManager.getProperty("In_Console");
		
	}
	
	public static boolean In_Textfield() {
		
		return PropertyManager.getProperty("In_Textfield");
		
	}
	
	public static boolean Out_Console() {
		
		return PropertyManager.getProperty("Out_Console");
		
	}
	
	public static boolean Out_Textfield() {
		
		return PropertyManager.getProperty("Out_Textfield");
		
	}
	
	public static boolean RandomNumber() {
		
		return PropertyManager.getProperty("RandomNumber");
		
	}
	
	public static boolean RandomLetters() {
		
		return PropertyManager.getProperty("RandomLetters");
		
	}
	
	public static boolean RandomString() {
		
		return PropertyManager.getProperty("RandomString");
		
	}
	
	public static boolean SHA256() {
		
		return PropertyManager.getProperty("SHA256");
		
	}
	
	public static boolean MD5() {
		
		return PropertyManager.getProperty("MD5");
		
	}
	
	public static boolean CountSymbols() {
		
		return PropertyManager.getProperty("CountSymbols");
		
	}
	
	public static boolean CountSymbolAppearance() {
		
		return PropertyManager.getProperty("CountSymbolAppearance");
		
	}
	
	public static boolean GUI() {
		
		return PropertyManager.getProperty("GUI");
		
	}
	
}
