package model;

import java.sql.SQLException;

import dataconnect.Dataconnet;

public class MDonvi {

	public static Object getID() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return Dataconnet.getID("DonViTinh","MaDonVi");
	}

	public static void insert(String[] arrcolumn, Object[] data, String[] datatype) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Dataconnet.insert("DonViTinh", arrcolumn , data, datatype);
	}

}
