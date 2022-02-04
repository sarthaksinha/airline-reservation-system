package com.model;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class updatecustomerdetails {
	String output;
	int count=0;
	   public int r(String nusername, String nname, Integer nage, String nemail, Long nmob) {
		   try{
			  
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		     
		      String sql;
		      
		      sql = "Update users set cname=?,cage=?,cmail=?,cmob=? where cusername=?";
		      PreparedStatement pst = conn.prepareStatement(sql);
		   
			 
				    pst.setString(1, nname);
				    pst.setInt(2, nage);
				    pst.setString(3, nemail);
				    pst.setLong(4, nmob);
				    pst.setString(5, nusername);
				    pst.executeUpdate();
				    
			count++;
			System.out.println(count);

				conn.close();  	
		      }
			catch(Exception e)
		   
			{
				
				System.out.println(e);
			}
			  return count; 
	   }	  
}
