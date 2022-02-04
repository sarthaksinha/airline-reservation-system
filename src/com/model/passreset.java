package com.model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
public class passreset{
	String op;
	double multiply;
	String[] output = new String[5];
	int count=0; int i;
	
	public int returnpassword(String email,String mob,String user)
	   {
		   String smail=null;
		   String smob=null;
		   String spassword=null;
		   int count=0;
		   try{
			      Class.forName("oracle.jdbc.driver.OracleDriver");
				  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			      Statement stmt = conn.createStatement();
			      String sql;
			      sql = "select cmail,cmob from users  where cusername='"+user+"'";
			      ResultSet rs = stmt.executeQuery(sql);
				  while(rs.next())
					{  
					  smail=rs.getString(1);
					  smob=rs.getString(2);
					}
				 
				  if(email.equals(smail) && mob.equals(smob))
					{
					  count=1;
					}
				  conn.close();
		   }
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return count;
		}
	
	public int newpass(String password,String muser)
	{
		   int count=0;
		   try{
			      Class.forName("oracle.jdbc.driver.OracleDriver");
				  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				  String sql ="update users set cpassword=? where cusername=?";
			      PreparedStatement pst = conn.prepareStatement(sql);
			        pst.setString(1,password);
			        pst.setString(2,muser);
			        pst.executeUpdate();
			        pst.close();
			        count=1;
		   }
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return count;
}
}