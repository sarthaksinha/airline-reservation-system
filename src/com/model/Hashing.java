package com.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
public class Hashing {
       
       public int Authorize(String username,String pass)
       {
       
              int ret = 0;
       try{
              
              //loading drivers
              Class.forName("oracle.jdbc.driver.OracleDriver");

              // connection
              Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
                     

              Statement stmt=con.createStatement();
              String md = md5(pass);
              String sql = "SELECT COUNT(*) FROM Users WHERE cusername = '"+ username+"'"+ "AND cpassword = '"+md+"'";
              ResultSet rs = stmt.executeQuery(sql);
               int cnt=0;
               int count = 0;
              while(rs.next())
              {
                     cnt = rs.getInt(1);
                     System.out.println(username);
                     System.out.println(md);
                     count ++;
                     
              }
              ret=cnt;
              
              String query = "update Users set cpassword = ? where cusername = '"+ username+"'";
              PreparedStatement preparedStmt = con.prepareStatement(query);
              for(int i = 1; i<=count;i++)
              preparedStmt.setString(i,md);
              preparedStmt.executeUpdate();
              
       }
       catch(Exception e)
       {
              e.printStackTrace();
       }
       return ret;
       }
       
       public void Insert(String user,String pass)
       {
       
              try{
      			Class.forName("oracle.jdbc.driver.OracleDriver");
      			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
      			String md = md5(pass);
      			String query = "insert into Users(cusername,cpassword) values(?,?)";
                  PreparedStatement preparedStmt2 = conn.prepareStatement(query);
                  preparedStmt2.setString(1,user);
                  preparedStmt2.setString(2,md);
                  preparedStmt2.executeUpdate();
      			}
      		catch(Exception e)
      		{
      			System.out.println(e);
      		}
       }
              
       
       public static String md5(String input) {
              
              String md5 = null;
              
              if(null == input) return null;
              
                     
              MessageDigest digest;
              try {
              digest = MessageDigest.getInstance("MD5");
              digest.update(input.getBytes(), 0, input.length());

              //Converts message digest value in base 16 (hex) 
              md5 = new BigInteger(1, digest.digest()).toString(16);
              }
              catch (NoSuchAlgorithmException e) {
                     
                     e.printStackTrace();
              }
              
              return md5;
       }
       
}



