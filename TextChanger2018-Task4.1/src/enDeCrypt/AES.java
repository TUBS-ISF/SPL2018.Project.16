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

public class AES implements interfaces.TwoArguments {
	
	/**
	 * 
	 * This class gets an input String and an password with AES.
	 * First the input is encrypted and afterwards decrypted again.
	 * 
	 * Warning: Currenty somehow *not* compactible with other AES en/decryptors.
	 * Possible reasons:
	 * -Wrong hash in line "MessageDigest.getInstance("SHA-256")"
	 * -Wrong mode in line "Cipher.getInstance("AES/ECB/PKCS5Padding")"
	 * 
	 * Warning: Program can't even decrypt it's own results.
	 * It needs to decrypt the input directly, not the stuff he had just
	 * encrypted.
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
			final SecretKeySpec key = convertPassword(password);
			if (key == null) {
				return "Error: AES: Can't convert the key from String to SecretKeySpec.";
			}
			
			// prepare the cipher for encryption
			Cipher cipherEncrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
			
			// encrypt the input with the cipher
			byte[] encryptedByte = cipherEncrypt.doFinal(input.getBytes());
			
			// convert bytes to Base64 String (for readability).
			BASE64Encoder encryptedBASE64 = new BASE64Encoder();
			String resultEncrypted = encryptedBASE64.encode(encryptedByte);
			
			// prepare the cipher for decryption
			Cipher cipherDecrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
			
			/*
			// decrypt the previously encrypted input
			byte[] decryptedByte = cipherDecrypt
					.doFinal(Base64.getDecoder().decode(input));
			String resultDecrypted = new String(decryptedByte);
			*/
			
			/*
			String resultDecrypted = new String(
					cipherDecrypt.doFinal(Base64.getDecoder().decode(input)));
			*/
			
			// TODO: It should decrypt the input, not the previous results.
			// decrypt the previously encrypted input
			byte[] decryptedByte = cipherDecrypt.doFinal(encryptedByte);
			String resultDecrypted = new String(decryptedByte);
			
			String resultNote1 = "Warning: Buggy! Don't use this program.";
			
			String resultNote2 = "Note: The given input had been encrypted and "
					+ "afterwards decrypted again, using the same password. "
					+ "(Since it's unknown here whether the original input was "
					+ "already encrypted or not.)";
			
			result = resultNote1 + "\n" + resultNote2 + "\n\n" + "Encrypted:\n" + resultEncrypted
					+ "\n\nDecrypted:\n" + resultDecrypted + "\n";
			
			return result;
			
			// catches for possible exceptions.
		} catch (NoSuchAlgorithmException e) {
			result = "Error: AES: NoSuchAlgorithmException";
			return result;
			
		} catch (NoSuchPaddingException e) {
			result = "Error: AES: NoSuchAlgorithmException";
			return result;
			
		} catch (InvalidKeyException e) {
			result = "Error: AES: InvalidKeyException";
			return result;
			
		} catch (IllegalBlockSizeException e) {
			result = "Error: AES: IllegalBlockSizeException";
			return result;
			
		} catch (BadPaddingException e) {
			result = "Error: AES: BadPaddingException";
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
			
			// only use the first 128 bit
			passwordByte = Arrays.copyOf(passwordByte, 16);
			
			// key for encryption
			key = new SecretKeySpec(passwordByte, "AES");
			
			return key;
			
			// catches for possible exceptions.
		} catch (UnsupportedEncodingException e) {
			return key;
		} catch (NoSuchAlgorithmException e) {
			return key;
		}
		
	}
	
}
