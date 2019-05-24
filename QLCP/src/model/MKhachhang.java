package model;

import java.sql.SQLException;

import dataconnect.Dataconnet;

public class MKhachhang {

	public static Object getID() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Dataconnet.getID("KhachHangThanThiet","MaKhachHang");
	}

	public static void insert(String[] arrcolumn, Object[] data, String[] datatype) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Dataconnet.insert("KhachHangThanThiet", arrcolumn , data, datatype);
	}

}
