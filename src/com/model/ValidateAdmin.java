package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ValidateAdmin {
	int count;
	   public int r(String n, String n2) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      sql = "select ausername, apassword from admin";
		      ResultSet rs = stmt.executeQuery(sql); 
			
			
				while(rs.next())
				{  
				    String semail=rs.getString(1);
				    String spass=rs.getString(2);
					if(n.equals(semail) && n2.equals(spass))
					{
						count=1;
						break;
					}
					else count=0;
				}  
				
				conn.close();  	
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
		return count;
	   		}
}