package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class configues whether an plugin is enabled
 * and the number of arguments it has.
 * 
 * To change the configuration just change the values here.
 *
 */
public class PluginManager {
	
	public static HashMap<String, List<Integer>> pluginList() {
		
		/*
		 * 1. argument = enabled (1=yes, 0=no)
		 * 2. argument = number of arguments
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
