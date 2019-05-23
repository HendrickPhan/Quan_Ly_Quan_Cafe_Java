package controller;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import controller.CEncode;
import model.MTkhoan;;

public class CDangnhap {

	public static void login(String usename, String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		password=CEncode.encodeString(password);
		MTkhoan.login(usename,password);
		
	}

}
