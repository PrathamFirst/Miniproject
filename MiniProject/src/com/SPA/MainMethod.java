package com.SPA;
import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainMethod {
	
	static String result = "User Not Found!";
      Connection con=null;
	PreparedStatement ps=null; 
	
	public void userData(String User_id,String FirstName,String Password,String Address,String email_id) {
		try {
			ConnectionTest test=new ConnectionTest();
			con=test.getConnectionDetails();
			ps=con.prepareStatement("insert into registration (User_id,FirstName,Password,Address,email_id) values (?,?,?,?,?)");
			ps.setString(1,User_id);
			ps.setString(2,FirstName);
			ps.setString(3,Password);
			ps.setString(4,Address);
			ps.setString(5,email_id);
			int i=ps.executeUpdate();
			System.out.println("SUCCESFULLY REGISTERED.....");
			System.out.println("------------------------------------------------------------------------------------------");
		} catch (Exception e) {
		e.printStackTrace();
		}
	
		
	}
	public static void register() {
		
		Scanner sc=new Scanner(System.in);
		 
			System.err.println("please Set user id:-");
			String User_id = sc.next();
			System.err.println("Please Enter FirstName:-");
			String FirstName = sc.next();
			System.err.println("Please Set Password:-");
			String Password = sc.next();
			System.err.println("Please Set Address:-");
			String Address = sc.next();
			System.err.println("Please Set email_id:-");
			String email_id = sc.next();
			MainMethod input = new MainMethod();
			input.userData(User_id, FirstName, Password, Address, email_id);
			
		
	}
	public static void signIn() {		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Borntobeanengg@22");

			Statement smt=cn.createStatement();

			DataInputStream KB=new DataInputStream(System.in);

			//input a particular employee id of which we want to display record
			System.out.println("welcome please login to proceed:-");
			System.out.println("Enter User_id:");
			String eid=KB.readLine();
			System.out.println("Enter Password:");
			String Password=KB.readLine();
			//query to display a particular record from table employee where empid(employee id) is equals to eid
			String q="Select * from inventory.Registration where Password='"+Password+"'and User_ID='"+eid+"'";

			//to execute query
			ResultSet rs=smt.executeQuery(q);

			//to print the resultset on console
			
			if(rs.next())	
			{
				result="User Found!";
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("");
				System.out.println("Your personal details :-");
				System.out.println("Name:-"+rs.getString(2));
				System.out.println("City:-"+rs.getString(4));
				System.out.println("Email-Id:-"+rs.getString(5));
			}
			else
			{
			
				System.out.println(result);
			}
			cn.close();
			
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {

		System.out.println("WELCOME TO SPA "+"\n"+"CREATE YOUR PROFILE HERE:-");
		//register();
		signIn();
		if (result.equals("User Found!")) {
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.err.println("                              HELLO THERE!"
		+"\n"+"                             WELCOME TO SPA"
				+"\n"+"                     We’re in Business to Improve Lives"+"\n"+"         We have wide collection of products.....FEEL FREE TO EXPLORE ");
		System.out.println("");
		DataProduct.main();
		System.out.println("-----------------------------------------------------------------------------------------");
		UserMenu.run();
		}
	}

}
