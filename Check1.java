

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Check1
 */
@WebServlet("/Check1")
public class Check1 extends HttpServlet {
	String month;
	String[] output = new String[5];
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
			
		String marrcity=request.getParameter("arrcity");
		String mdepcity=request.getParameter("depcity");
		String mdate=request.getParameter("depdate");
		
		//PW.println(mdepcity);
		//PW.println(marrcity);
		//PW.println(mdate);
		
        String[] parts = mdate.split(Pattern.quote("/"));  
        String part1 = parts[0]; //mm
        String part2 = parts[1]; //dd
        String part3 = parts[2]; //yyyy
        
        String date=part3+"-"+part1+"-"+part2;
		
	    Search s = new Search();
		output=s.r(mdepcity, marrcity, date);
		
		int i=0;
		while(output[i]!=null)
		{
		PW.println(output[i] + "<br><hr><br>");
		i++;
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
