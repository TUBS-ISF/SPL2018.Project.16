package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class configues whether an plugin is enabled,
 * the number of required arguments
 * and the helping text.
 *
 */
public class PluginManager {
	
	/**
	 * Creates an HashMap which contains enabled/disabled status
	 * and the number of required arguments.
	 * 
	 * Explanation of the values:
	 * key: the name of the operation (lowercase)
	 * value 0: enabled or disabled (details see below)
	 * value 1: number of arguments
	 * value 2: helping text (see method "formatHelp" below for details)
	 * 
	 * Status enabled/disabled:
	 * enabled: "1", "true", "enabled", "positive"
	 * disabled: "0", "false", "disabled", "negative"
	 * 
	 * @return The HashMap.
	 */
	static HashMap<String, List<String>> pluginList() {
		
		// The list of all Plugins with info to status and argument number
		HashMap<String, List<String>> pluginList = new HashMap<String, List<String>>();
		
		// Plugin UpperCase
		List<String> uppercasevalues = new ArrayList<String>();
		uppercasevalues.add("enabled");
		uppercasevalues.add("1");
		uppercasevalues
				// .add("UpperCase: Makes all letters UPPERCASE.\n\tUsage: \"UpperCase 'input'\"");
				.add(formatHelp("UpperCase: Makes all letters UPPERCASE.", "UpperCase 'input'"));
		pluginList.put("uppercase", uppercasevalues);
		
		// Plugin LowerCase
		List<String> lowercasevalues = new ArrayList<String>();
		lowercasevalues.add("enabled");
		lowercasevalues.add("1");
		lowercasevalues
				.add(formatHelp("LowerCase: Makes all letters lowercase.", "LowerCase 'input'"));
		pluginList.put("lowercase", lowercasevalues);
		
		// Plugin RandomNumber
		List<String> randomnumbervalues = new ArrayList<String>();
		randomnumbervalues.add("enabled");
		randomnumbervalues.add("1");
		randomnumbervalues
				.add(formatHelp("RandomNumber: Calculates an random number of given legth.",
						"RandomNumber 'length'"));
		pluginList.put("randomnumber", randomnumbervalues);
		
		// Plugin MD5
		List<String> md5values = new ArrayList<String>();
		md5values.add("enabled");
		md5values.add("1");
		md5values.add(
				formatHelp("MD5: Calculates the hash value of the input with the MD5 algorithm.",
						"MD5 'input'"));
		pluginList.put("md5", md5values);
		
		// Plugin CountSymbols
		List<String> countsymbolsvalues = new ArrayList<String>();
		countsymbolsvalues.add("enabled");
		countsymbolsvalues.add("1");
		countsymbolsvalues.add(formatHelp("CountSymbols: Counts the symbols of the input.",
				"CountSymbols 'input'"));
		pluginList.put("countsymbols", countsymbolsvalues);
		
		// Plugin ROT13
		List<String> rot13values = new ArrayList<String>();
		rot13values.add("enabled");
		rot13values.add("1");
		rot13values.add(formatHelp("ROT13: Makes an ROT13-modification of the given input.",
				"ROT13 'input'"));
		pluginList.put("rot13", rot13values);
		
		// Plugin AES
		List<String> aesvalues = new ArrayList<String>();
		aesvalues.add("enabled");
		aesvalues.add("2");
		aesvalues
				.add(formatHelp("AES: Encrypt/Decrypt the input with AES using the given password.",
						"AES 'password' 'input'"));
		pluginList.put("aes", aesvalues);
		
		// Plugin SHA256
		List<String> sha256values = new ArrayList<String>();
		sha256values.add("enabled");
		sha256values.add("1");
		sha256values.add(formatHelp(
				"SHA256: Calculates the hash value of the input with the SHA256 algorithm.",
				"SHA256 'input'"));
		pluginList.put("sha256", sha256values);
		
		// Plugin DES
		List<String> desvalues = new ArrayList<String>();
		desvalues.add("enabled");
		desvalues.add("2");
		desvalues
				.add(formatHelp("DES: Encrypt/Decrypt the input with DES using the given password.",
						"DES 'password' 'input'"));
		pluginList.put("des", desvalues);
		
		// Plugin LongComSub
		List<String> longcomsubvalues = new ArrayList<String>();
		longcomsubvalues.add("enabled");
		longcomsubvalues.add("2");
		longcomsubvalues.add(formatHelp(
				"LongComSub: Calculates the Longest Common Substring of two given Strings.",
				"LongComSub 'String1' 'String2'"));
		pluginList.put("longcomsub", longcomsubvalues);
		
		// Plugin ROT13
		List<String> reversevalues = new ArrayList<String>();
		reversevalues.add("enabled");
		reversevalues.add("1");
		reversevalues.add(formatHelp("Reverse: Reverses the given input.", "Reverse 'input'"));
		pluginList.put("reverse", reversevalues);
		
		// Plugin CountSymAppear
		List<String> countsymappearvalues = new ArrayList<String>();
		countsymappearvalues.add("enabled");
		countsymappearvalues.add("1");
		countsymappearvalues.add(formatHelp(
				"CountSymAppear: Counts the appearance of each symbol in the given input.",
				"CountSymAppear 'input'"));
		pluginList.put("countsymappear", countsymappearvalues);
		
		// Plugin RandomNumber
		List<String> randomstringvalues = new ArrayList<String>();
		randomstringvalues.add("enabled");
		randomstringvalues.add("1");
		randomstringvalues.add(formatHelp(
				"RandomString: Calculates an random String (numbers and letters) of given legth.",
				"RandomString 'length'"));
		pluginList.put("randomstring", randomstringvalues);
		
		// Plugin RandomNumber
		List<String> randomlettersvalues = new ArrayList<String>();
		randomlettersvalues.add("enabled");
		randomlettersvalues.add("1");
		randomlettersvalues.add(formatHelp(
				"RandomLetters: Calculates an random String (only letters) of given legth.",
				"RandomLetters 'length'"));
		pluginList.put("randomletters", randomlettersvalues);
		
		return pluginList;
	}
	
	// formates the helping text.
	// First a short description, second the usage.
	private static String formatHelp(String description, String usage) {
		
		return (description + "\n\tUsage: \"" + usage + "\"\n");
	}
	
}
