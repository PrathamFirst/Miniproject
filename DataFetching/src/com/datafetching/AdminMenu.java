package com.datafetching;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminMenu {
	

		public static void run() {
			String Product="";
			for (int i=0;i<=4;i++) {	
			
			try{
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				//serverhost = localhost, port=3306, username=root, password=123
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Pratham@6322");

				Statement smt=cn.createStatement();

				DataInputStream KB=new DataInputStream(System.in);

				//input a particular employee id of which we want to display record
				System.out.println("Enter product ID:");
				String eid=KB.readLine();

				//query to display a particular record from table employee where empid(employee id) is equals to eid
				String q="Select * from person where ID='"+eid+"'";

				//to execute query
				ResultSet rs=smt.executeQuery(q);

				//to print the resultset on console
				if(rs.next())
				{
					System.out.println(rs.getString(1)+","+rs.getString(2));
					String x=rs.getString(1);
					String y=rs.getString(2);
					Product+=x+" "+y+",";
					System.out.print(Product);
					System.out.println();
					
				}
				else
				{
					System.out.println(" Product Not Found...");
				}
				cn.close();
			
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}


