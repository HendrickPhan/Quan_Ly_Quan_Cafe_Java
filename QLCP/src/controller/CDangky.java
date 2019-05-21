package controller;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import model.MDangky;;

public class CDangky {

	public static void insert(String string, String string2, String string3, String[] arr) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		arr[1]=encodeString(arr[1]);
		System.out.println(arr[1]);
		MDangky.insert(string,string2,string3,arr);
	}
	public static String encodeString(String text) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException  {
		
	String SECRET_KEY = "stackjava.com.if";
    SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] byteEncrypted = cipher.doFinal(text.getBytes());
    return Base64.getEncoder().encodeToString(byteEncrypted);
	}
}
