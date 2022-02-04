import java.io.IOException;
import java.io.PrintWriter;

import com.model.*;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SkadooshPayServlet")
public class SkadooshPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username=(String)session.getAttribute("username");
		String passname=(String)session.getAttribute("finalname");
		
		String sfid = (String) session.getAttribute("fid");
		String scompany = (String) session.getAttribute("company");
		String sdep = (String) session.getAttribute("departure");
		String sdate = (String) session.getAttribute("departuredate");
		Integer sdeptime = Integer.parseInt((String) session.getAttribute("departuretime"));
		String sarr = (String) session.getAttribute("arrival");
		String date1 = (String) session.getAttribute("arrivaldate");
		Integer sarrtime = Integer.parseInt((String) session.getAttribute("arrivaltime"));
		Integer sseats = Integer.parseInt((String) session.getAttribute("maxseats")); // Maximum Seats
		Integer mseat = (Integer) session.getAttribute("requiredseats"); // Required Seats
	
		double fare = Double.parseDouble((String) session.getAttribute("fare"));
	
        tempFlightDetailsSetter inserts = new tempFlightDetailsSetter();
        inserts.addTempFlightDetailsSet(sfid,scompany,sdep,sarr,sdate,sdeptime,date1,sarrtime,sseats,mseat,fare,username);
		
		tempPassengerDetailsSetter set=new tempPassengerDetailsSetter();
		set.addTempPassengerDetailsSet(passname, username);
		
		double amount=fare*mseat;
		
		//String bank_name="SkadooshBank";
		PrintWriter pw = response.getWriter();
		//System.out.println("here===="+bank_name);
		System.out.println(request.getServerPort());
		
		response.sendRedirect("http://172.17.170.139:8989/SkadooshPaymentGateway/Gateway?to_accno=1037061045655507&ifsc_code=SBIL0000279&amount="+amount+"&link=http://localhost:"+request.getServerPort()+"/CodingProject/booksSkadoosh.jsp?userid="+session.getAttribute("username")+"@status=");
	}


}