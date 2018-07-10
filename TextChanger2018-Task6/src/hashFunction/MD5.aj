package hashFunction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import inputOutput.WriteOutput;
import main.Parameters;

public aspect MD5 {
	
	/**
	 * This aspect enables the feature "MD5."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			
			if (operation.equalsIgnoreCase("MD5")) {
				try {
					// prepare md
					final MessageDigest md = MessageDigest.getInstance("MD5");
					md.reset();
					
					// create hash in byte format
					md.update(argumentOne.getBytes());
					final byte resultByte[] = md.digest();
					
					final String resultString = DatatypeConverter.printHexBinary(resultByte);
					
					WriteOutput.write(resultString);
					
				} catch (NoSuchAlgorithmException e) {
					
					WriteOutput.write("Intern Error: Hash Algorithm \"MD5\" not found.");
				}
			}
		}
		
	}

}
