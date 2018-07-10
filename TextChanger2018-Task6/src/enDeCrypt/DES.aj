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

public aspect DES {
	
	/**
	 * This aspect enables the feature "DES."
	 * 
	 * @param input
	 *        The Input.
	 */
	after() returning (boolean ready): execution(boolean pluginReady()) {
		
		if (ready) {
			
			final String operation = Parameters.getOperation();
			final String argumentOne = Parameters.getArgumentOne();
			final String argumentTwo = Parameters.getArgumentTwo();
			
			if (operation.equalsIgnoreCase("DES")) {
			
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
					
					// convert the password from String to SecretKeySpec
					
					SecretKeySpec key = null;
					
					try {
						// Convert the password into an byte-Array.
						byte[] passwordByte;
						
						passwordByte = password.getBytes("UTF-8");
						
						// hash the array with SHA-256
						final MessageDigest sha = MessageDigest.getInstance("SHA-256");
						passwordByte = sha.digest(passwordByte);
						
						// only use the first 64 bit
						passwordByte = Arrays.copyOf(passwordByte, 8);
						
						// key for encryption
						key = new SecretKeySpec(passwordByte, "DES");
						
						// catches for possible exceptions.
					} catch (UnsupportedEncodingException e) {
						WriteOutput.write("Error: DES: UnsupportedEncodingException");
						return;
					} catch (NoSuchAlgorithmException e) {
						WriteOutput.write("Error: DES: NoSuchAlgorithmException");
						return;
					}
					
					if (key == null) {
						WriteOutput.write("Error: DES: Can't convert the key from String to SecretKeySpec.");
					}
					
					// prepare cipher for encryption
					final Cipher cipherEncrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
					cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
					
					// Encrypt the text
					byte[] textEncrypted = cipherEncrypt.doFinal(input.getBytes());
					
					// convert bytes to Base64 String (for readability).
					final BASE64Encoder encryptedBASE64 = new BASE64Encoder();
					String resultEncrypted = encryptedBASE64.encode(textEncrypted);
					
					// prepare cipher for encryption
					final Cipher cipherDecrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
					cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
					
					// Decrypt the text
					final byte[] textDecrypted = cipherDecrypt.doFinal(textEncrypted);
					String resultDecrypted = new String(textDecrypted);
					
					final String resultNote1 = "Warning: Buggy! Don't use this program.";
					
					final String resultNote2 = "Note: The given input had been encrypted and "
							+ "afterwards decrypted again, using the same password. "
							+ "(Since it's unknown here whether the original input was "
							+ "already encrypted or not.)";
					
					result = resultNote1 + "\n" + resultNote2 + "\n\n" + "Encrypted:\n" + resultEncrypted
							+ "\n\nDecrypted:\n" + resultDecrypted + "\n";
					
					WriteOutput.write(result);
					return;
					
				} catch (NoSuchAlgorithmException e) {
					WriteOutput.write("Error: DES: NoSuchAlgorithmException");
					return;
					
				} catch (NoSuchPaddingException e) {
					WriteOutput.write("Error: DES: NoSuchAlgorithmException");
					return;
					
				} catch (InvalidKeyException e) {
					WriteOutput.write("Error: DES: InvalidKeyException");
					return;
					
				} catch (IllegalBlockSizeException e) {
					WriteOutput.write("Error: DES: IllegalBlockSizeException");
					return;
					
				} catch (BadPaddingException e) {
					WriteOutput.write("Error: DES: BadPaddingException");
					return;
				}
			}
		}
	}

}
