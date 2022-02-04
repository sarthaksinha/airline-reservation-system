import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Databasejdbc{

	public String JDBC_Driver = "oracle.jdbc.driver.OracleDriver";
	public String DB_Url = "jdbc:oracle:thin:@localhost:1521:XE";
	public String USER = "scott";
	public String pass = "tiger";
	public  Connection con = null ;

	  public Databasejdbc(){

	     JDBC_Driver = "oracle.jdbc.driver.OracleDriver";
	     DB_Url = "jdbc:oracle:thin:@localhost:1521:XE";
	     USER = "scott";
	     pass = "tiger";


	      try{
	      Class.forName(JDBC_Driver);
	        //System.out.println("Connecting to Database");
	        con = DriverManager.getConnection(DB_Url, USER, pass);
	        }
	      catch(Exception e){System.out.println(e);
	        }

	  }

	
	
	public void InsertData(String username, String name,String age,String email,String mob,String passwd){

		{
		    try{

		        String sql ="insert into users values(?,?,?,?,?,?)";
		        PreparedStatement pst = con.prepareStatement(sql);
		        pst.setString(1,username);
		        pst.setString(2, name);
		        pst.setString(3, age);
		        pst.setString(4, email);
		        pst.setString(5, mob);
		        pst.setString(6, passwd);
		        		        
		        pst.executeUpdate();
		        
		        pst.close();
		        con.close();
		    }catch(Exception e){ e.printStackTrace();}
		}
	}
	
	public int ValidateUsername(String cusername){
				int count=0;	
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select cusername from users");
				while(rs.next())
				{
					String pusername=rs.getString(1);
	
					if((cusername.equals(pusername))){
						count=1;
						break;
					}
					
					else
					{
						count=0;
					}
				}
				
				
				con.close();
			}

		catch(Exception e){
		System.out.println(e);}
		
			return count;
		}	

}


