package model;

import java.sql.SQLException;

import dataconnect.Dataconnet;

public class MThucdon {

	public static void insert(String[] arrcolumn, Object[] data, String[] datatype) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Dataconnet.insert("ThucDon", arrcolumn , data, datatype);
	}

	public static int getID() throws ClassNotFoundException, SQLException {
		return Dataconnet.getID("ThucDon","MaMon");
		// TODO Auto-generated method stub
		
	}

}
