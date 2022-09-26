package com.SPA;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	 Connection con=null;

	public  Connection getConnectionDetails() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Borntobeanengg@22");
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;

	}

}
