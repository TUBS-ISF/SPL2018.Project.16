package hashFunction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class MD5 implements interfaces.OneArgument {
	
	/**
	 * This class gets an String for input and returns the MD5 hash.
	 * 
	 * @param input
	 *        String to hash
	 * @return String hashed with MD5
	 */
	@Override
	public String calculate(String input) {
		
		try {
			// prepare md
			final MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			
			// create hash in byte format
			md.update(input.getBytes());
			final byte resultByte[] = md.digest();
			
			final String resultString = DatatypeConverter.printHexBinary(resultByte);
			
			return resultString;
			
		} catch (NoSuchAlgorithmException e) {
			
			return "Intern Error: Hash Algorithm \"MD5\" not found.";
		}
	}
}
