import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class Register {
	   public void r(String n, String n2) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		      PreparedStatement pstmt = null;
		      String query = "insert into ProjUser(email,password) values(?,?)";
		      pstmt = conn.prepareStatement(query);
		      pstmt.setString(1,n);
		      pstmt.setString(2,n2); 
		      pstmt.executeUpdate();
		      conn.close(); 
		      }
			catch(Exception e)
			{
				System.out.println(e);
			}
   		}
}