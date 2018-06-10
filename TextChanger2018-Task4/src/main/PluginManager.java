package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class configues whether an plugin is enabled
 * and the number of arguments it has.
 *
 */
public class PluginManager {
	
	/**
	 * Creates an HashMap which contains enabled/disabled status
	 * and the number of required arguments.
	 * 
	 * Explanation of the values:
	 * key: the name of the operation (lowercase)
	 * value 1: enabled (1=yes, 0=no)
	 * value 2: number of arguments
	 * 
	 * @return The HashMap.
	 */
	public static HashMap<String, List<Integer>> pluginList() {
		
		// The list of all Plugins with info to status and argument number
		HashMap<String, List<Integer>> pluginList = new HashMap<String, List<Integer>>();
		
		// Plugin UpperCase
		List<Integer> uppercasevalues = new ArrayList<Integer>();
		uppercasevalues.add(1);
		uppercasevalues.add(1);
		pluginList.put("uppercase", uppercasevalues);
		
		// Plugin LowerCase
		List<Integer> lowercasevalues = new ArrayList<Integer>();
		lowercasevalues.add(1);
		lowercasevalues.add(1);
		pluginList.put("lowercase", lowercasevalues);
		
		// Plugin RandomNumber
		List<Integer> randomnumbervalues = new ArrayList<Integer>();
		randomnumbervalues.add(1);
		randomnumbervalues.add(1);
		pluginList.put("randomnumber", randomnumbervalues);
		
		// Plugin MD5
		List<Integer> md5values = new ArrayList<Integer>();
		md5values.add(1);
		md5values.add(1);
		pluginList.put("md5", md5values);
		
		// Plugin CountSymbols
		List<Integer> countsymbolsvalues = new ArrayList<Integer>();
		countsymbolsvalues.add(1);
		countsymbolsvalues.add(1);
		pluginList.put("countsymbols", countsymbolsvalues);
		
		// Plugin ROT13
		List<Integer> rot13values = new ArrayList<Integer>();
		rot13values.add(1);
		rot13values.add(1);
		pluginList.put("rot13", rot13values);
		
		// Plugin AES
		List<Integer> aesvalues = new ArrayList<Integer>();
		aesvalues.add(1);
		aesvalues.add(2);
		pluginList.put("aes", aesvalues);
		
		return pluginList;
	}
	
}
