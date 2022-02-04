package com.model;

import java.sql.*;
public class ValidateLogin {
       int count;
          public int r(String n, String n2) {
                 try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                     Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
                    Statement stmt = conn.createStatement();
                    String sql;
                    sql = "select cusername, cpassword from users";
                    ResultSet rs = stmt.executeQuery(sql); 
                    Hashing b = new Hashing();
                       String encpass = b.md5(n2);
                       System.out.println(encpass+"Hashed passwd");
                       
                           while(rs.next())
                           {  
                               String suname=rs.getString(1);
                               String spass=rs.getString(2);
                                  if(n.equals(suname) && encpass.equals(spass))
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
