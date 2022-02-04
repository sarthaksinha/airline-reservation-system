

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminUpdate
 */
@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		
		String mdeparture=request.getParameter("departure");
		String marrival=request.getParameter("arrival");
		String mintime=request.getParameter("intime");
		String mouttime=request.getParameter("outtime");
		String mseats=request.getParameter("seats");
		String mcompany=request.getParameter("company");
		
		HttpSession session=request.getSession(true);
		
		String mfid=(String)session.getAttribute("fid");
		
		updateFlight v=new updateFlight();
		int f=v.r(mfid,mdeparture,marrival,mintime,mouttime,mcompany,mseats);
		
		if(f==1)
		{
			response.sendRedirect("ADMIN INDEX PAGE");
		}
		else{
			response.sendRedirect("adminFlightUpdate.java");
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
