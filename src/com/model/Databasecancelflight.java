package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Databasecancelflight {
	public void cancelflight(String n1) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		      PreparedStatement pstmt = null;
		      String query = "delete from flightdetails where Flight_id=?";
		      pstmt = conn.prepareStatement(query);
		      pstmt.setString(1,n1);
		      
		     pstmt.executeUpdate();
		      
		      conn.close(); 
		      
				
			  }
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	
	

}
