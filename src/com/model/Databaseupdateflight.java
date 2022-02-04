package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Databaseupdateflight {
	int y;
	public int updateflight(String n1, String n2,String n3,String n4,String n5,int n6,String n7,int n8,int n9) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		     PreparedStatement pstmt = null;
		     String query = "update flightdetails set Flight_ID=?,company=?,dep_loc=?,arr_loc=?,dep_date=TO_DATE(?,'YYYY-MM-DD'),dep_time=?,arr_date=TO_DATE(?,'YYYY-MM-DD'),arr_time=?,seats=? where flight_id=?";
		     pstmt = conn.prepareStatement(query);
		     pstmt.setString(1,n1);
		     pstmt.setString(2,n2);
		     pstmt.setString(3,n3);
		     pstmt.setString(4,n4);
		     pstmt.setString(5,n5);
		     pstmt.setInt(6,n6);
		     pstmt.setString(7,n7);
		     pstmt.setInt(8,n8);
		     pstmt.setInt(9,n9);
		     pstmt.setString(10,n1);
		      
		     System.out.println(n4);
		     y=pstmt.executeUpdate();
		      
		      conn.close(); 
		      
				
			  }
			catch(Exception e)
			{
				System.out.println(e);
			}
		   return y;
		}
	
}
