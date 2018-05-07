package main;

public class introduction {
	
	static void introduce() {
		
		String text1 = "Welcome to TextChanger2018!";
		String text2 = "For a list of all possible functions type 'help'. For Information about the license type 'license'.";
		String text3 = "To exit the program type 'exit' or 'quit'";
		
		WriteOutput.write(text1);
		WriteOutput.write(text2);
		WriteOutput.write(text3);
		
	}
	
	static String license() {
		
		String seperator = System.getProperty("line.separator");
		
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
}
