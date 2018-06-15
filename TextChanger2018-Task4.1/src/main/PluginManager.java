package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class configues whether an plugin is enabled, the number of arguments it has
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
	 * value 0: enabled (1=yes, 0=no)
	 * value 1: number of arguments
	 * value 2: helping text (see method "formatHelp" below for details)
	 * 
	 * @return The HashMap.
	 */
	public static HashMap<String, List<String>> pluginList() {
		
		// The list of all Plugins with info to status and argument number
		HashMap<String, List<String>> pluginList = new HashMap<String, List<String>>();
		
		// Plugin UpperCase
		List<String> uppercasevalues = new ArrayList<String>();
		uppercasevalues.add("1");
		uppercasevalues.add("1");
		uppercasevalues
				// .add("UpperCase: Makes all letters UPPERCASE.\n\tUsage: \"UpperCase 'input'\"");
				.add(formatHelp("UpperCase: Makes all letters UPPERCASE.", "UpperCase 'input'"));
		pluginList.put("uppercase", uppercasevalues);
		
		// Plugin LowerCase
		List<String> lowercasevalues = new ArrayList<String>();
		lowercasevalues.add("1");
		lowercasevalues.add("1");
		lowercasevalues
				.add(formatHelp("LowerCase: Makes all letters lowercase.", "LowerCase 'input'"));
		pluginList.put("lowercase", lowercasevalues);
		
		// Plugin RandomNumber
		List<String> randomnumbervalues = new ArrayList<String>();
		randomnumbervalues.add("1");
		randomnumbervalues.add("1");
		randomnumbervalues
				.add(formatHelp("RandomNumber: Calculates an random number of given legth.",
						"RandomNumber 'length'"));
		pluginList.put("randomnumber", randomnumbervalues);
		
		// Plugin MD5
		List<String> md5values = new ArrayList<String>();
		md5values.add("1");
		md5values.add("1");
		md5values.add(
				formatHelp("MD5: Calculates the hash value of the input with the MD5 algorithm.",
						"MD5 'input'"));
		pluginList.put("md5", md5values);
		
		// Plugin CountSymbols
		List<String> countsymbolsvalues = new ArrayList<String>();
		countsymbolsvalues.add("1");
		countsymbolsvalues.add("1");
		countsymbolsvalues.add(formatHelp("CountSymbols: Counts the symbols of the input.",
				"CountSymbols 'input'"));
		pluginList.put("countsymbols", countsymbolsvalues);
		
		// Plugin ROT13
		List<String> rot13values = new ArrayList<String>();
		rot13values.add("1");
		rot13values.add("1");
		rot13values.add(formatHelp("ROT13: Makes an ROT13-modification of the given input.",
				"ROT13 'input'"));
		pluginList.put("rot13", rot13values);
		
		// Plugin AES
		List<String> aesvalues = new ArrayList<String>();
		aesvalues.add("1");
		aesvalues.add("2");
		aesvalues
				.add(formatHelp("AES: Encrypt/Decrypt the input with AES using the given password.",
						"AES 'password' 'input'"));
		pluginList.put("aes", aesvalues);
		
		return pluginList;
	}
	
	/**
	 * Formats the helping text.
	 * 
	 * @param description
	 *        Short description of what the function does.
	 * @param usage
	 *        The usage of the function.
	 * @return The calculated helping text.
	 */
	private static String formatHelp(String description, String usage) {
		
		return (description + "\n\tUsage: \"" + usage + "\"\n");
	}
	
}
