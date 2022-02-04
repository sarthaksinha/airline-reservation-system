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
import javax.servlet.http.HttpSession;

import com.model.Search;

/**
 * Servlet implementation class Check1
 */
@WebServlet("/Check2")
public class Check2 extends HttpServlet {
	String month;
	String[] output = new String[5];
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Check2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		HttpSession session=request.getSession(true);

		String user=(String)session.getAttribute("username");
		String pass=(String)session.getAttribute("password");
		String marrcity=(String)session.getAttribute("arrival");
		String mdepcity=(String)session.getAttribute("departure");
		String mdate=(String)session.getAttribute("date");
		String flightid=(String)session.getAttribute("flightid");

		
		
		/*String[] parts = mdate.split(Pattern.quote("/"));  
		String part1 = parts[0]; //mm
		String part2 = parts[1]; //dd
		String part3 = parts[2]; //yyyy

		String date=part3+"-"+part1+"-"+part2;*/
		
		String date=mdate;

		Search s = new Search();
		output=s.r(mdepcity, marrcity, date);

		if(user!=null){
			PW.println("<p align=right>User : "+user+"</p>");
		}
		
		PW.println("<form action=Radio2 method=get>");
		int i=0;
		while(output[i]!=null)
		{
			PW.println("<div style=background-color:mintcream;color:black;padding:20px;>"
					+"<input type=radio name=selection value="+output[i]+">"+output[i] + ""
					+ "<hr></div>");
			i++;
		}
		
		
		PW.println("<input type=submit value=submit>");
		PW.println("</form>");

		PW.println("Go back to <a href=Index.html>Booking Page</a>");
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
