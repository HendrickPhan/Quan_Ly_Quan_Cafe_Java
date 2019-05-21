package dataconnet;

import java.sql.*;

public class DCDangky {
	public static Connection connet() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/text","root","");
	}
	public static void insert(String string, String string2, String string3, String[] arr) throws ClassNotFoundException, SQLException {
		Connection con=connet();
		 if (con != null) 
				System.out.println("Connected");
			else
				System.out.println("Not Connected");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from acc");  
			String query = " insert into ";
			query+=string;
			query+=" ("+string2+",";
			query+=string3+")";
			query+=" values (?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, arr[0]);
			preparedStmt.setString (2, arr[1]);
			if( preparedStmt.executeUpdate() != 0) {
				System.err.println("insert thanh cong account");
			}
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  ");  
			con.close();  
	}
}
