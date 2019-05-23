package dataconnect;

import java.sql.*;

import javax.swing.JOptionPane;


public class Dataconnet {
	public static Connection connet() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/qlcf","root","");
	}
	
	public static void insert(String table, String[] arrcolumn, Object[] data, String[] datatype) throws ClassNotFoundException, SQLException {
		String s;
		int in;
		Connection con=connet();
		 	int n=arrcolumn.length;
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from tkhoan");  
			String mysql = " insert into ";
			mysql+=table+" (";
			for(int i=0;i<2;i++)
			{
				if(i==n-1)
					mysql+=arrcolumn[i]+")";
				else
					mysql+=arrcolumn[i]+",";
			}
			mysql+=" values (";
			for(int i=0;i<2;i++)
			{
				if(i==n-1)
					mysql+="?)";
				else
					mysql+="?,";
			}
			PreparedStatement preparedStmt = con.prepareStatement(mysql);
			for(int i=0;i<2;i++)
			{
				if(datatype[i]=="string")
				{
					s=(String) data[i];
					preparedStmt.setString (i+1, s);
				}
				if(datatype[i]=="int")
				{
					in=(int) data[i];
					preparedStmt.setInt (i+1, in);
				}
			}
			if( preparedStmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong account");
			}
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");  
			con.close();  
	}
	
	public static void login(String table, String usename, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=connet();
		String mysql = " select * from "+table+" where usename=? and password=?";
		PreparedStatement ps=con.prepareStatement(mysql);
		ps.setString(1, usename);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			JOptionPane.showMessageDialog(null, "Logged in successfully");
		}
		else
			JOptionPane.showMessageDialog(null, "Login failed");
	}
}
