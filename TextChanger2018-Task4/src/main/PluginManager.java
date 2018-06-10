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
	
	final static int upperCaseArguments = 1;
	final static boolean upperCaseEnabled = true;
	
	final static int lowerCaseArguments = 1;
	final static boolean lowerCaseEnabled = true;
	
	final static int randomNumberArguments = 1;
	final static boolean randomNumberEnabled = true;
	
	final static int md5Arguments = 1;
	final static boolean md5Enabled = true;
	
	final static int countSymbolsArguments = 1;
	final static boolean countSymbolsEnabled = true;
	
	final static int rot13Arguments = 1;
	final static boolean rot13Enabled = true;
	
	final static int aesArguments = 2;
	final static boolean aesEnabled = true;
	
	public static HashMap<String, List<Integer>> pluginList() {
		
		/*
		 * 1. Argument = Enabled (1=yes, 0=no)
		 * 2. Argument = number of arguments
		 */
		
		HashMap<String, List<Integer>> pluginList = new HashMap<String, List<Integer>>();
		List<Integer> uppercasevalues = new ArrayList<Integer>();
		uppercasevalues.add(1);
		uppercasevalues.add(1);
		pluginList.put("uppercase", uppercasevalues);
		
		List<Integer> lowercasevalues = new ArrayList<Integer>();
		lowercasevalues.add(1);
		lowercasevalues.add(1);
		pluginList.put("lowercase", lowercasevalues);
		
		List<Integer> randomnumbervalues = new ArrayList<Integer>();
		randomnumbervalues.add(1);
		randomnumbervalues.add(1);
		pluginList.put("randomnumber", randomnumbervalues);
		
		List<Integer> md5values = new ArrayList<Integer>();
		md5values.add(1);
		md5values.add(1);
		pluginList.put("md5", md5values);
		
		List<Integer> countsymbolsvalues = new ArrayList<Integer>();
		countsymbolsvalues.add(1);
		countsymbolsvalues.add(1);
		pluginList.put("countsymbols", countsymbolsvalues);
		
		List<Integer> rot13values = new ArrayList<Integer>();
		rot13values.add(1);
		rot13values.add(1);
		pluginList.put("rot13", rot13values);
		
		List<Integer> aesvalues = new ArrayList<Integer>();
		aesvalues.add(1);
		aesvalues.add(2);
		pluginList.put("aes", aesvalues);
		
		return pluginList;
	}
	
}
