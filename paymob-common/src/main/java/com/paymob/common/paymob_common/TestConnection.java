package com.paymob.common.paymob_common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	
	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://192.168.225.62:3306/test","root","Micro@123");  
			
			System.out.println("rana"+con.getCatalog());
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from testing");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			con.close();  
			
			System.out.println("asdas");
			}catch(Exception e){ System.out.println(e);}  
			}  
	
	
}
