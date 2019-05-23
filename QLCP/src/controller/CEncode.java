package controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CEncode {
	public static String encodeString(Object data) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException  {
		
	String SECRET_KEY = "stackjava.com.if";
    SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] byteEncrypted = cipher.doFinal(((String) data).getBytes());
    return Base64.getEncoder().encodeToString(byteEncrypted);
	}
}
