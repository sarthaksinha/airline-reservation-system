package com.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class tempFlightDetailsSetter {
	public void addTempFlightDetailsSet(String n1, String n2,String n3,String n4,String n5,int n6,String n7,int n8,int n9, int n10, double n11, String n12) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		      PreparedStatement pstmt = null;
		      String query = "insert into tempFlightDetails values(?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?,?)";
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
		      pstmt.setInt(10,n10);
		      pstmt.setDouble(11,n11);
		      pstmt.setString(12,n12);
		      int v=1111111;
		      System.out.println(n7);
		     v=pstmt.executeUpdate();
		     System.out.println(v+"CheckTempInsert");
		      conn.close(); 
			  }
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
}
