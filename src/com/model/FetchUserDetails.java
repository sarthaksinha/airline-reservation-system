package com.model;

import java.sql.*;

public class FetchUserDetails {
	String output;
	int count=0;
	   public String r(String nusername) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      sql = "select * from users";
		      ResultSet rs = stmt.executeQuery(sql);
		      
			
			  while(rs.next())
				{  
				    String username=rs.getString(1);
				    String name=rs.getString(2);
				    String age=rs.getString(3);
				    String email=rs.getString(4);
				    String mob=rs.getString(5);
				    
					if(nusername.equals(username))
					{
						output=name+" "+age+" "+email+" "+mob;
						break;
					}
				}
			  
				conn.close();  	
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
		   return output;
	   		}
}