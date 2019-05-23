package model;

import dataconnect.Dataconnet;

public class MTkhoan {

	public static void insert(String[] arrcolumn, Object[] data, String[] datatype) {
		// TODO Auto-generated method stub
		 try {
			   Dataconnet.insert("Tkhoan", arrcolumn , data, datatype);
		     }
		   catch(Exception e){ System.out.println(e);} 
	}

	public static void login(String usename, String password) {
		// TODO Auto-generated method stub
		 try {
			   Dataconnet.login("Tkhoan", usename,password);
		     }
		   catch(Exception e){ System.out.println(e);} 
	}

}
