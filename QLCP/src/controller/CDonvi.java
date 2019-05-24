package controller;
import java.sql.SQLException;

import model.MDonvi;
public class CDonvi {

	public static void insert(Object[] data) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String[] arrcolumn=new String[2];
		arrcolumn[0]="MaDonVi";
		arrcolumn[1]="TenDonVi";
		String [] datatype=new String[2];
		datatype[0]="int";
		datatype[1]="string";
		data[0]=MDonvi.getID();
		MDonvi.insert(arrcolumn, data, datatype);
	}

}
