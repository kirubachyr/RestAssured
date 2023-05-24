package com.learning.RestAssured;

import java.sql.*;
class SampleDBConnection
{
	

	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","kiru","Kiruba.27");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from emp;");
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString("name");
			
			System.out.println("id"+id+ "Name" + name);
			
		}
		stmt.close();
		con.close();
		
		
		
		
	}
}