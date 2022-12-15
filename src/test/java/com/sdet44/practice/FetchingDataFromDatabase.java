package com.sdet44.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchingDataFromDatabase {
	
	public static void main(String[] args) throws SQLException {
//Step 1--> create the object for Driver implementation class and register driver to jdbc
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
// Step 2 --> Get/estrablish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	try {	//step3 --> create statement 
		Statement statement = connection.createStatement();
	//step4 ---> execute query
		ResultSet result = statement.executeQuery("select * from project;");
		//step5 --> utilization/ fetch particular colum data
		while(result.next()) {
			System.out.println(result.getString("project_name"));
		}
	}
		finally {
			//Step6 --> close db connection			
			connection.close();
			System.out.println("Connection closed sucessfully");
		}
	}

}
