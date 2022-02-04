
package com.model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
public class Ticket {
	String op;
	String[] output = new String[500];
	int count=0;

	   public String[] ValUser(String cuser,String pnr) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      sql = "select * from ticket where pnr="+pnr+"%";
		      ResultSet rs = stmt.executeQuery(sql);
		      
			  
			  while(rs.next())
				{  
				  	
				    String sfid=rs.getString(2);
				    String spnr=rs.getString(1);
			 	    String scompany=rs.getString(3);
				    String sdeptloc=rs.getString(4);
				    String sarrloc=rs.getString(5);
				    String sdeptdate=rs.getString(6);
				    String sdepttime=rs.getString(7);
				    String sarrdate=rs.getString(8);
				    String sarrtime=rs.getString(9);
				    int sfare=rs.getInt(10);
				    String spassengername=rs.getString(11);
				    String susername=rs.getString(12);
				    
				    
	
					if(cuser.equals(susername))
					{
						op= spnr + " " + sfid + " " + scompany+ " " + sdeptloc+ " " + sarrloc + " " + sdeptdate+ " " + sdepttime+ " " + sarrdate + " " + sarrtime+" "+sfare+" "+spassengername+" "+susername;
						output[count]=op;
						count++;
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
