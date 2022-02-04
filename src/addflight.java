import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Pattern;


public class addflight {
	void addflightdetails(String mdept,String marr,String mseat,String mcompany,String mfid,String depttime,String arrtime)
	{
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stmt=con.createStatement();
	        String sql ="insert into flight values(?,?,?,?,TO_DATE(?),TO_DATE(?),TO_NUMBER(?))";

//INSERT INTO Flight VALUES('GO234F','GOAIR',60,'MUMBAI','KEREALA','27-SEP-2017 9.00.00.000000 AM','27-SEP-2017 11.00.00.000000 AM'); 
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, mfid);
	        pst.setString(2, mcompany);
	        pst.setString(3,mdept);
	        pst.setString(4,marr);
	        pst.setString(5,depttime);
	        pst.setString(6,arrtime);
	        pst.setString(7,mseat);
	        pst.executeUpdate();
	        pst.close();
	        con.close();
	    }catch(Exception e){ e.printStackTrace();}
	}
	
	void addfare(String mfid,String mfare)
	{
try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement stmt=con.createStatement();
	        String sql ="insert into fare values(?,TO_NUMBER(?))";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, mfid);
	        pst.setString(2, mfare);
	        pst.executeUpdate();
	        pst.close();
	        con.close();
	    }catch(Exception e){ e.printStackTrace();}
	}

	}

	



