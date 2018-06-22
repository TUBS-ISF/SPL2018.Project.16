package main;

import java.util.List;
import java.util.Map.Entry;

import inputOutput.WriteOutput;
import main.PluginManager;

public class Texts {
	
	/**
	 * This class prints the introduction which is shown on startup.
	 */
	static void introduce() {
		
		final String introduction = "Welcome to TextChanger2018! (Version 4.1)\n"
				+ "For a list of all possible functions type 'help'. For Information about the license type 'license'.\n"
				+ "To exit the program type 'exit' or 'quit' or 'q'.";
		
		WriteOutput.write(introduction);
		
	}
	
	/**
	 * This class returns the license of the program.
	 * 
	 * @return
	 */
	static String license() {
		
		final String seperator = System.getProperty("line.separator");
		
		final String license = "This program is free software: you can redistribute it and/or modify"
				+ seperator + "it under the terms of the GNU General Public License as published by"
				+ seperator + "the Free Software Foundation, either version 3 of the License, or"
				+ seperator + "(at your option) any later version." + seperator + seperator
				
				+ "This program is distributed in the hope that it will be useful," + seperator
				+ "but WITHOUT ANY WARRANTY; without even the implied warranty of" + seperator
				+ "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the" + seperator
				+ "GNU General Public License for more details." + seperator + seperator
				
				+ "You should have received a copy of the GNU General Public License" + seperator
				+ "along with this program.  If not, see <https://www.gnu.org/licenses/>.";
		
		return license;
	}
	
	/**
	 * This class prints the program help/manual.
	 */
	static void help() {
		// TODO: Enable only when necessary.
		WriteOutput.write("This is an overview of all possible arguments:");
		WriteOutput.write("Note: 'input' stands for any input.");
		WriteOutput.write("Note: command argument isn't case-sensitive, but 'input' is.");
		WriteOutput.write(
				"NOTE: Currently it is not possible to use input containing whitespaces. Using quotation marks doesn't help.");
		WriteOutput.write("*************");
		
		WriteOutput.write("help: Shows this page ;).");
		WriteOutput.write("license: Shows the license (GPLv3).");
		WriteOutput.write("exit/quit/q: Closes the program.");
		WriteOutput.write("");
		
		for (Entry<String, List<String>> helpPluginList : PluginManager.pluginList().entrySet()) {
			
			List<String> helptest = helpPluginList.getValue();
			String helptest2 = helptest.get(2);
			WriteOutput.write(helptest2);
			
		}
		
	}
	
}
