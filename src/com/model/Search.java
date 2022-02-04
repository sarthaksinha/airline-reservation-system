package com.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
public class Search {
	String op;
	double multiply;
	String[] output = new String[5];
	int count=0; int i;
	
	public String returnsysdate()
	   {
		   String sysdate=null;
		   try{
			      Class.forName("oracle.jdbc.driver.OracleDriver");
				  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			      Statement stmt = conn.createStatement();
			      String sql;
			      sql = "select trunc(sysdate) from dual ";   
			      ResultSet rs = stmt.executeQuery(sql);
				  while(rs.next())
					{  
					  sysdate=rs.getString(1);

					}
				  conn.close();
		   }
		catch(Exception e)
		{
			System.out.println(e);
		}
		   String[] parts=sysdate.split(Pattern.quote(" "));
        String sdate = parts[0];
        System.out.println(sdate+"inside search file");
		return sdate;
		}
	
	   public String[] r(String ndepcity, String narrcity, String ndate) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      Search fetchsysdate=new Search();
		      String sysdate=fetchsysdate.returnsysdate();
		      sql = "select flight_id,company,dep_loc,arr_loc,dep_date,dep_time,arr_date,arr_time,seats,bfare from flightdetails,fare where company=fcompany ";
		      
		      ResultSet rs = stmt.executeQuery(sql);
		      
			  
			  while(rs.next())
				{  
				    String sfid=rs.getString(1);
				    String scompany=rs.getString(2);
				    String sdep=rs.getString(3);
				   
	                //System.out.println(date);
	                
	                String sarr=rs.getString(4);
	                String sdepdate=rs.getString(5);
	                String[] parts = sdepdate.split(Pattern.quote(" "));
	                String date = parts[0];
	                System.out.println(date);
	                
	                String sdeptime=rs.getString(6);
	                String sarrdate=rs.getString(7);
	                String[] parts1 = sarrdate.split(Pattern.quote(" "));
	                String date1 = parts1[0];
	                String sarrtime=rs.getString(8);
	                String sseats=rs.getString(9);
	                int sbfare=rs.getInt(10);
	                
	               

	        
				    
					if(ndepcity.equals(sdep) && narrcity.equals(sarr) && ndate.equals(date))
					{

		                Date d1 = null;
		        		try {
		        			d1 = new SimpleDateFormat("yyyy-M-dd").parse(date);
		        		} catch (ParseException e1) {
		        			// TODO Auto-generated catch block
		        			e1.printStackTrace();
		        		}
		        		Date d2 = null;
		        		try {
		        			d2 = new SimpleDateFormat("yyyy-M-dd").parse(sysdate);
		        		} catch (ParseException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		}

		        long diff = d1.getTime() - d2.getTime();

		        System.out.println("Difference between  " + d1 + " and "+ d2+" is "
		            + (diff / (1000 * 60 * 60 * 24)) + " days.");
		        
		        if(diff>=30){
		        	multiply=1.00;
		        }
		        else if(diff>=15 && diff<30){
		        	multiply=1.25;
		        }
		        else{
		        	multiply=1.50;
		        }
		        
		        
						 
						System.out.println("FLIGHT ID:"+" "+sfid+" "+scompany+" "+sdep+" "+date+" "+sdeptime+" "+sarr+" "+date1+" "+sarrtime+" "+sseats+" "+(sbfare*multiply));
						op=sfid + " " + scompany + " " + sdep+ " " + date+ " " + sdeptime + " " + sarr+ " " + date1+ " " + sarrtime + " " + sseats+" "+(sbfare*multiply);
						output[count]=op;
						count++;
						i++;
					}
				
				}
				conn.close();  	
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
		   if(i>0){
			   return output;
			   }
			   else{
				   return null;
			   }
	   		}
	   
	   
}