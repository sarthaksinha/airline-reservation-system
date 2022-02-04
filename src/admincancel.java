import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;




public class admincancel {
	void cancelflight(String mfid)
	{
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
	        String sql ="delete from flight where flight_id=?";


	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, mfid);
	        pst.executeUpdate();
	        pst.close();
	        con.close();
	    }catch(Exception e){ e.printStackTrace();}
	}
	

	}

	



