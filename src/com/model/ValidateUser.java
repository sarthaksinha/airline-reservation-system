package com.model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
public class ValidateUser {
	String op;
	String[] output = new String[500];
	int count=0;

	   public String[] ValUser(String cuser) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      sql = "select * from ticket";
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

	
	   public int DelUser(String cpnr,String fid) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		   
		      String sql ="delete from ticket where pnr_no=(?)";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        pst.setString(1,cpnr);		         
		        pst.executeUpdate();
		        count=1;
		        String query1="update flightdetails set seats=seats+1 where flight_id=?";
		        PreparedStatement pstmt1 = conn.prepareStatement(query1);
			    pstmt1.setString(1,fid );
			    pstmt1.executeUpdate();
		        pst.close();
		        System.out.println("Refund is under process");
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
		   return count;
	   		}
	   public String[] ValUserDeleteupdate(String cuser) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      sql = "select * from ticket where DEP_DATE >=( select trunc(sysdate) from dual)";
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
