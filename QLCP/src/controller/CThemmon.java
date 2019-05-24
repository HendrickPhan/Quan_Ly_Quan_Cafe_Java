package controller;
import java.sql.SQLException;

import model.MThucdon;
public class CThemmon {

	public static void insert(Object[] data) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String[] arrcolumn=new String[3];
		arrcolumn[0]="MaMon";
		arrcolumn[1]="TenMon";
		arrcolumn[2]="DonGia";
		String [] datatype=new String[3];
		datatype[0]="int";
		datatype[1]="string";
		datatype[2]="int";
		Object[] datawithid=new Object[3];
		datawithid[0]=MThucdon.getID();
		datawithid[1]=data[0];
		datawithid[2]=data[1];
		MThucdon.insert(arrcolumn, datawithid, datatype);
	}

}
