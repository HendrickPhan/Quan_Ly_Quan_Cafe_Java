package controller;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import controller.CEncode;
import model.MTkhoan;;

public class CDangky {

	public static void insert(Object[] data) throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		data[1]=CEncode.encodeString(data[1]);
		System.out.println(data[1]);
		String[] arrcolumn=new String[2];
		arrcolumn[0]="usename";
		arrcolumn[1]="password";
		String [] datatype=new String[2];
		datatype[0]="string";
		datatype[1]="string";
		MTkhoan.insert(arrcolumn,data,datatype);
	}
}
