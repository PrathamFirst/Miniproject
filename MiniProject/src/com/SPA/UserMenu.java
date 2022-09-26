package com.SPA;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserMenu {
	static String Product="";
	static int Price = 0;

		public static void run() {
			
			for (int i=0;i<5;i++) {
				
				try{
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				//serverhost = localhost, port=3306, username=root, password=Borntobeanengg@22
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/INVENTORY","root","Borntobeanengg@22");

				Statement smt=cn.createStatement();

				DataInputStream KB=new DataInputStream(System.in);

				//input a particular employee id of which we want to display record
				
				
				System.out.println("");
				System.err.print("=>>>Please Enter product ID which you want add in Your cart:");
				String eid=KB.readLine();

				//query to display a particular record from table employee where empid(employee id) is equals to eid
				String q="Select * from product where ID='"+eid+"'";

				//to execute query
				ResultSet rs=smt.executeQuery(q);

				//to print the resultset on console
				if(rs.next())
				{
					System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
					
					String x=rs.getString(1);
					String y=rs.getString(2);
					String w=rs.getString(3);
					String z=rs.getString(4);
					Product+=x+" "+y+" "+w+" "+z+",";
					
					int p=rs.getInt(3);
					Price+=p;
					System.out.println("Your product list is ready!");
					System.out.println(Product);
					System.out.println("Total Amount of products in your cart:-");
					System.out.println(Price);
					
					
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
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			System.out.println("YOUR ORDERD ITEMS:-");
			System.out.println(Product);
			System.out.println("TOTAL AMOUNT");
			System.out.println(Price+"/-");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------");
			System.out.println("                                          THANK-YOU");
			System.out.println("                                          VISIT-AGAIN");
	}

}
