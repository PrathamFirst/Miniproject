package com.datafetching;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataProduct {

	public static void main() {
		
			try {
				//load driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//establish connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Pratham@6322");
				
				//prepared statement
				PreparedStatement state= con.prepareStatement("select * from person");
				
				ResultSet rs = state.executeQuery();
				
				while(rs.next()) {
					System.out.print("Id:"+rs.getInt(1)+"\t");
					System.out.print("Discription:"+rs.getString(2)+"\t");
					
					System.out.println();
				} 

			} catch (Exception e) {
				e.printStackTrace();
	}
			


}

}


