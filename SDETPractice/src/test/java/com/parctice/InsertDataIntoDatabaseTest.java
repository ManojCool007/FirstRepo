package com.parctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabaseTest {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet55", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into rmg values('Phoenix','API',4);";
		int result = state.executeUpdate(query);
		System.out.println(result);
		con.close();
	}
	
}
