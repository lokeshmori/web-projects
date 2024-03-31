package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn = null; // conn is variable
	
	public static Connection getConn() { // Connection method 
		
		try {
			
			if(conn == null) {
				
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","W@2915djkq#");
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
