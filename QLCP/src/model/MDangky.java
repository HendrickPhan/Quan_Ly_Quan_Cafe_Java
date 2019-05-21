package model;

import dataconnet.DCDangky;
public class MDangky {

	public static void insert(String string, String string2, String string3, String[] arr) {
		// TODO Auto-generated method stub
		   try {
			   DCDangky.insert(string, string2, string3, arr);
		     }
		   catch(Exception e){ System.out.println(e);}  
	}
	
}
