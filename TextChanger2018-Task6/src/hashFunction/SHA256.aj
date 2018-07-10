package hashFunction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect SHA256 {
	
	/**
	 * This aspect enables the feature "SHA256."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("SHA256")) {
				try {
					// prepare md
					final MessageDigest md = MessageDigest.getInstance("SHA-256");
					md.reset();
					
					// create hash in byte format
					md.update(argumentOne.getBytes());
					final byte resultByte[] = md.digest();
					
					final String resultString = DatatypeConverter.printHexBinary(resultByte);
					
					WriteOutput.write(resultString);
					
				} catch (NoSuchAlgorithmException e) {
					
					WriteOutput.write("Intern Error: Hash Algorithm \"SHA256\" not found.");
				}
			}
		}
		
	}

}
