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

import inputOutput.WriteOutput;
import main.Parameters;
import sun.misc.BASE64Encoder;

public aspect AES {
	
	/**
	 * This aspect enables the feature "AES."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			final String argumentTwo = Parameters.getArgumentTwo();
			
			if (operation.equalsIgnoreCase("AES")) {
			
				String result = null;
				final String input;
				final String password;
				
				// Optinal reverse the order of the arguments 'password' and 'input'.
				// false: 1. input 2. password
				// true: 1. password 2. input
				final boolean reverseArguments = true;
				if (reverseArguments) {
					String inputCopy = argumentOne;
					String passwordCopy = argumentTwo;
					input = passwordCopy;
					password = inputCopy;
					
					// Delete the copies because why not?
					inputCopy = null;
					passwordCopy = null;
				}
				
				try {
					
					SecretKeySpec key = null;
					
					// convert the password from String to SecretKeySpec
					try {
						// Convert the password into an byte-Array.
						byte[] passwordByte;
						
						passwordByte = password.getBytes("UTF-8");
						
						// hash the array with SHA-256
						MessageDigest sha = MessageDigest.getInstance("SHA-256");
						passwordByte = sha.digest(passwordByte);
						
						// only use the first 128 bit
						passwordByte = Arrays.copyOf(passwordByte, 16);
						
						// key for encryption
						key = new SecretKeySpec(passwordByte, "AES");
						
						// catches for possible exceptions.
					} catch (UnsupportedEncodingException e) {
						WriteOutput.write("Error: AES: UnsupportedEncodingException");
						return;
					} catch (NoSuchAlgorithmException e) {
						WriteOutput.write("Error: AES: NoSuchAlgorithmException");
						return;
					}
					
					if (key == null) {
						WriteOutput.write("Error: AES: Can't convert the key from String to SecretKeySpec.");
					}
					
					// prepare the cipher for encryption
					final Cipher cipherEncrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
					cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
					
					// encrypt the input with the cipher
					final byte[] encryptedByte = cipherEncrypt.doFinal(input.getBytes());
					
					// convert bytes to Base64 String (for readability).
					final BASE64Encoder encryptedBASE64 = new BASE64Encoder();
					String resultEncrypted = encryptedBASE64.encode(encryptedByte);
					
					// prepare the cipher for decryption
					final Cipher cipherDecrypt = Cipher.getInstance("AES/ECB/PKCS5Padding");
					cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
					
					// TODO: It should decrypt the input, not the previous results.
					// decrypt the previously encrypted input
					final byte[] decryptedByte = cipherDecrypt.doFinal(encryptedByte);
					String resultDecrypted = new String(decryptedByte);
					
					final String resultNote1 = "Warning: Buggy! Don't use this program.";
					
					final String resultNote2 = "Note: The given input had been encrypted and "
							+ "afterwards decrypted again, using the same password. "
							+ "(Since it's unknown here whether the original input was "
							+ "already encrypted or not.)";
					
					result = resultNote1 + "\n" + resultNote2 + "\n\n" + "Encrypted:\n" + resultEncrypted
							+ "\n\nDecrypted:\n" + resultDecrypted + "\n";
					
					WriteOutput.write(result);
					return;
					
					// catches for possible exceptions.
				} catch (NoSuchAlgorithmException e) {
					WriteOutput.write("Error: AES: NoSuchAlgorithmException");
					return;
					
				} catch (NoSuchPaddingException e) {
					WriteOutput.write("Error: AES: NoSuchPaddingException");
					return;
					
				} catch (InvalidKeyException e) {
					WriteOutput.write("Error: AES: InvalidKeyException");
					return;
					
				} catch (IllegalBlockSizeException e) {
					WriteOutput.write("Error: AES: IllegalBlockSizeException");
					return;
					
				} catch (BadPaddingException e) {
					WriteOutput.write("Error: AES: BadPaddingException");
					return;
				}
			}
		}
		
	}

}
