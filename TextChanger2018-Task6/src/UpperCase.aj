import inputOutput.WriteOutput;
import interfaces.ManageOneArgument;
import interfaces.ManageTwoArguments;
import main.Parameters;

public aspect UpperCase {
	
	// TODO: Ein Returnwert muss ermöglicht werden
	// after(String input) returning(String result): execution(boolean startPlugins(String)) && args(input)
	// Das returning bezieht sich auf den return-Wert der Methode, die bei After gennant wird.
	// Mögliche Lösung: Hier direkt ein WriteOutput einbauen und einfach weiter durch laufen lassen.
	
	after(String input): execution(boolean startPlugins(String)) && args(input) {
		
		final String result;
		
		Parameters para = new Parameters(input);
		String operation = para.getOperation();
		String argumentOne = para.getArgumentOne();
		String argumentTwo = para.getArgumentTwo();
		
		final ManageOneArgument manageOne;
		final ManageTwoArguments manageTwo;
		
		if (operation.equalsIgnoreCase("UpperCase")) {
			manageOne = new ManageOneArgument(new simpleModifier.UpperCase(), argumentOne);
			result = manageOne.startCalculating();
			WriteOutput.write(result);
			
			Parameters.setFeatureUsedTrue();
			
			//para.setFeatureUsedTrue();
		}
		
	}

}
