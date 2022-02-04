package com.model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class booking {
	int count;
	   public int r(String n, String n2, String n3, String n4, String n5, String n6, Integer n7, String n8, Integer n9, double n10, String n11, String n12) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		      PreparedStatement pstmt = null,pstmt1=null;
		      
		      String query = "insert into ticket values(?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?)";
		      
		      pstmt = conn.prepareStatement(query);
		      pstmt.setString(1,n);
		      pstmt.setString(2,n2);
		      pstmt.setString(3,n3);
		      pstmt.setString(4,n4);
		      pstmt.setString(5,n5);
		      pstmt.setString(6,n6);
		      pstmt.setInt(7,n7);
		      pstmt.setString(8,n8);
		      pstmt.setInt(9,n9);
		      pstmt.setDouble(10,n10);
		      pstmt.setString(11,n11);
		      pstmt.setString(12,n12);
		      
		      count=pstmt.executeUpdate();
		      
		      String query1="update flightdetails set seats=seats-1 where flight_id=?";
		      pstmt1 = conn.prepareStatement(query1);
		      pstmt1.setString(1, n2);
		      
		      pstmt1.executeUpdate();
				conn.close();  	
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
		return count;
   		}
}