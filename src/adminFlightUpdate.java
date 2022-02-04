import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminFlightUpdate
 */
@WebServlet("/adminFlightUpdate")
public class adminFlightUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminFlightUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		
		String mfid=request.getParameter("fid");
		
		HttpSession session=request.getSession(true);
		
		session.setAttribute("fid",mfid);
		
		Adminsearch s = new Adminsearch();
		String output=s.r(mfid);
		
		if(output!=null){
		PW.println(""
				+ "<div style=background-color:ivory;color:black;padding:20px;>"
				+ "<form action=AdminUpdate method=get>"
				+ "<table>"
				+ "<tr><td>Enter new Departure City: </td><td><select name=depcity>"
				+"<option value=Delhi>Delhi</option>"
   				+"<option value=Mumbai>Mumbai</option>"
   				+"<option value=Jaipur>Jaipur</option>"
   				+"<option value=Bangalore>Bangalore</option>"
   				+"</select></td></tr>"
				+ "<tr><td>Enter new Arrival City: </td><td><select name=arrival required>"
				+ "<option value=Mumbai>Mumbai</option>"
				+ "<option value=Delhi>Delhi</option>"
				+ "<option value=Jaipur>Jaipur</option>"
				+ "<option value=Bangalore>Bangalore</option></select></td></tr>"
				+ "<tr><td>Enter new intime: </td><td><input type=date name=intime required/></td></tr>"
				+ "<tr><td>Enter new outtime: </td><td><input type=date name=outtime required/></td></tr>"
				+ "<tr><td>Enter new Company: </td><td><input type=text name=company required/></td></tr>"
				+ "<tr><td>Enter new seats: </td><td><input type=text name=seats required/></td></tr>"
				+"</table>"
				+ "<br><input type=submit value=Execute Update>"
				+"</div>"
				+"</form><hr>"
				+ "</body>");
		}  
		  
		else
		{
		
			response.sendRedirect("adminaAdd.html");
		}
		//UPDATE TUPLE WHERE FID=MFID
		
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
