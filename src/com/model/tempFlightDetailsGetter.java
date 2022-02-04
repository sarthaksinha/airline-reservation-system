package com.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
public class tempFlightDetailsGetter {
	String op=null;
	String[] output = new String[10];
	int count=0;
	   public String returnFlightDetails(String username) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql,sql1;
		      sql = "select * from tempflightdetails where username='"+username+"'";
		      
		      ResultSet rs = stmt.executeQuery(sql);
		      
			  
			  while(rs.next())
				{  
				    String sfid=rs.getString(1);
				    System.out.println(sfid);
				    String scompany=rs.getString(2);
				    System.out.println(scompany);
				    String sdep=rs.getString(3);
				    System.out.println(sdep);
	                String sarr=rs.getString(4);
	                System.out.println(sarr);
	                String sdepdate=rs.getString(5);
	                System.out.println(sdepdate);
	                String[] parts = sdepdate.split(Pattern.quote(" "));
	                String departuredate = parts[0];
	                System.out.println(departuredate);
	                
	                String sdeptime=rs.getString(6);
	                String sarrdate=rs.getString(7);
	                String[] parts1 = sarrdate.split(Pattern.quote(" "));
	                String arrivaldate = parts1[0];
	                String sarrtime=rs.getString(8);
	                String maxseats=rs.getString(9);
	                String reqseats=rs.getString(10);
	                String sbfare=rs.getString(11);
	                String username2=rs.getString(12);
	                
					op=sfid+" "+scompany+" "+sdep+" "+departuredate+" "+sdeptime+" "+sarr+" "+arrivaldate+" "+sarrtime+" "+maxseats+" "+reqseats+" "+sbfare+" "+username2;
					count++;

					}
			  
			  sql1 = "delete from tempflightdetails";
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