import java.sql.*;

public class updateFlight {
	String output;
	int count=0;
	   public int r(String nfid, String ndeparture, String narrival, String nintime, String nouttime, String ncompany, String nseats) {
		   try{
			   System.out.println(nfid);
		      Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		     
		      String sql;
		      
		      sql = "Update Flight set flight_id=?,company=?,dep_loc=?,arr_loc=?,intime=?,outtime=?,seats=? Where flight_id=?";
		      PreparedStatement pst = conn.prepareStatement(sql);
		    
		      System.out.println(nfid);
			 
				    pst.setString(1, nfid);
				    pst.setString(2, ncompany);
				    pst.setString(3, ndeparture);
				    pst.setString(4, narrival);
				    pst.setString(5, nintime);
				    pst.setString(6, nouttime);
				    pst.setString(7, nseats);
				    pst.setString(8, nfid);
				    pst.executeUpdate();
				    
			count++;
			System.out.println(count);

				conn.close();  	
		      }
			catch(Exception e)
		   
			{
				
				System.out.println(e);
			}
			  return count; 
	   }	  
}
