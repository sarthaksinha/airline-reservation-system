
import java.sql.*;

public class Adminsearch {
	String output;
	int count=0;
	   public String r(String nfid) {
		   try{
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		      Statement stmt = conn.createStatement();
		      String sql;
		      sql = "select * from flight";
		      ResultSet rs = stmt.executeQuery(sql);
		      
			
			  while(rs.next())
				{  
				    String sfid=rs.getString(1);
				    
					if(nfid.equals(sfid))
					{
						output=sfid;
						break;
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