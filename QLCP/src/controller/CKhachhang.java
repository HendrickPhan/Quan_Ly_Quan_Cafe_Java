package controller;

import java.sql.SQLException;

import model.MKhachhang;

public class CKhachhang {

	public static void insert(Object[] data) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String[] arrcolumn=new String[5];
		arrcolumn[0]="MaKhachHang";
		arrcolumn[1]="HoVaTen";
		arrcolumn[2]="SoDienThoai";
		arrcolumn[3]="DiaChi";
		arrcolumn[4]="Email";
		String [] datatype=new String[5];
		datatype[0]="int";
		datatype[1]="string";
		datatype[2]="int";
		datatype[3]="string";
		datatype[4]="string";
		data[0]=MKhachhang.getID();
		MKhachhang.insert(arrcolumn, data, datatype);
	}

}
