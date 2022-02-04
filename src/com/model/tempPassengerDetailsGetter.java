package com.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
public class tempPassengerDetailsGetter {
	String op=null;
	String[] output = new String[10];
	int count=0;
	   public String returnPassengerDetails(String checkUser) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql,sql1;
		      sql = "select * from tempPassengerDetail where usern='"+checkUser+"'";

		      ResultSet rs = stmt.executeQuery(sql);
		      
			  while(rs.next())
				{  
				    String sname=rs.getString(1);
					op=sname;
					count++;
					}
			  
			  sql1 = "delete from tempPassengerDetail";
			  stmt.executeQuery(sql1);
			  
				conn.close();  	
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
		   return op;
	   		}
}