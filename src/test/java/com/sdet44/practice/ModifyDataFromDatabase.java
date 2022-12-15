package com.sdet44.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		String brandName="MI";
		String mobileName="Note 11";
		String price="12345";
		//Step 1--> create the object for Driver implementation class and register driver to jdbc
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		// Step 2 --> Get/estrablish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3333/sdet44", "root", "root");
		 
		try {	
		//step3 --> create statement
		Statement statement = connection.createStatement();
		//step4 ---> execute query 
		int result = statement.executeUpdate("insert into mobile values('"+mobileName+"', "+price+", '"+brandName+"');");		
		//step5 --> validating data wheather updated or not
		if(result>=1) {
			System.out.println("Data updated sucessfully");
		}
		}
		catch (Exception e) {
			e.printStackTrace();	
		}
		finally {
			//Step6 --> close db connection
			connection.close();
			System.out.println("Connection closed sucessfully");
		}
	}
}
