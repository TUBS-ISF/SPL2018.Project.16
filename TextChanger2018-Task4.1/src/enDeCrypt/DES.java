package enDeCrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class DES implements interfaces.TwoArguments {
	
	/**
	 * 
	 * This class gets an input String and an password with AES.
	 * First the input is encrypted and afterwards decrypted again.
	 * 
	 * Warning: Doesn't work!
	 * See comments on AES.java for details.
	 * 
	 * @param input
	 *        The String to encrypt/decrypt
	 * 
	 * @param password
	 *        The password.
	 * 
	 * @return Returns the Encrypted and Decrypted results.
	 */
	@Override
	public String calculate(String input, String password) {
		
		String result = null;
		
		// Optinal reverse the order of the arguments 'password' and 'input'.
		// false: 1. input 2. password
		// true: 1. password 2. input
		final boolean reverseArguments = true;
		if (reverseArguments) {
			String inputCopy = input;
			String passwordCopy = password;
			input = passwordCopy;
			password = inputCopy;
			
			// Delete the copies because why not?
			inputCopy = null;
			passwordCopy = null;
		}
		
		try {
			
			// convert the password from String to SecretKeySpec
			SecretKeySpec key = convertPassword(password);
			if (key == null) {
				return "Error: DES: Can't convert the key from String to SecretKeySpec.";
			}
			
			// prepare cipher for encryption
			Cipher cipherEncrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
			
			// Encrypt the text
			byte[] textEncrypted = cipherEncrypt.doFinal(input.getBytes());
			
			// convert bytes to Base64 String (for readability).
			BASE64Encoder encryptedBASE64 = new BASE64Encoder();
			String resultEncrypted = encryptedBASE64.encode(textEncrypted);
			
			// prepare cipher for encryption
			Cipher cipherDecrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
			
			// Decrypt the text
			byte[] textDecrypted = cipherDecrypt.doFinal(textEncrypted);
			String resultDecrypted = new String(textDecrypted);
			
			String resultNote1 = "Warning: Buggy! Don't use this program.";
			
			String resultNote2 = "Note: The given input had been encrypted and "
					+ "afterwards decrypted again, using the same password. "
					+ "(Since it's unknown here whether the original input was "
					+ "already encrypted or not.)";
			
			result = resultNote1 + "\n" + resultNote2 + "\n\n" + "Encrypted:\n" + resultEncrypted
					+ "\n\nDecrypted:\n" + resultDecrypted + "\n";
			
			return result;
			
		} catch (NoSuchAlgorithmException e) {
			result = "Error: DES: NoSuchAlgorithmException";
			return result;
			
		} catch (NoSuchPaddingException e) {
			result = "Error: DES: NoSuchAlgorithmException";
			return result;
			
		} catch (InvalidKeyException e) {
			result = "Error: DES: InvalidKeyException";
			return result;
			
		} catch (IllegalBlockSizeException e) {
			result = "Error: DES: IllegalBlockSizeException";
			return result;
			
		} catch (BadPaddingException e) {
			result = "Error: DES: BadPaddingException";
			return result;
		}
		
	}
	
	// converts the password from String to SecretKeySpec. (moved here for readability)
	private static SecretKeySpec convertPassword(String password) {
		
		SecretKeySpec key = null;
		
		try {
			// Convert the password into an byte-Array.
			byte[] passwordByte;
			
			passwordByte = (password).getBytes("UTF-8");
			
			// hash the array with SHA-256
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			passwordByte = sha.digest(passwordByte);
			
			// only use the first 64 bit
			passwordByte = Arrays.copyOf(passwordByte, 8);
			
			// key for encryption
			key = new SecretKeySpec(passwordByte, "DES");
			
			// key = new SecretKeySpec(password.getBytes("UTF-8"), "AES");
			
			return key;
			
			// catches for possible exceptions.
		} catch (UnsupportedEncodingException e) {
			return key;
		} catch (NoSuchAlgorithmException e) {
			return key;
		}
		
	}
}
