package com.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class tempPassengerDetailsSetter {
	public void addTempPassengerDetailsSet(String n1, String n2) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		      PreparedStatement pstmt = null;
		      String query = "insert into tempPassengerDetail values(?, ?)";
		      pstmt = conn.prepareStatement(query);
		      pstmt.setString(1,n1);
		      pstmt.setString(2,n2);
		      int v;
		      System.out.println(n1);
		      v=pstmt.executeUpdate();
		      System.out.println(v+"CheckPassengerTempInsert");
		      conn.close(); 
			  }
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
}
