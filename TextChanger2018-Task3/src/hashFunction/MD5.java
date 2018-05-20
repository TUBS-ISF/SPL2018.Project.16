package hashFunction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class MD5 {
	
	/**
	 * This class gets an String for input and returns the MD5 hash.
	 * 
	 * @param input
	 *        String to hash
	 * @return String hashed with MD5
	 */
	public static String hash(String input) {
		
		try {
			// ready md
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			
			// create hash in byte format
			md.update(input.getBytes());
			byte resultByte[] = md.digest();
			
			String resultString = DatatypeConverter.printHexBinary(resultByte);
			
			// String resultString = resultBuffer.toString();
			
			return resultString;
			
		} catch (NoSuchAlgorithmException e) {
			
			return "Error: Hash Algorithm \"MD5\" not found.";
		}
	}
}
