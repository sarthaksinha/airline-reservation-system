import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/adminaAdd")
public class adminaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		//INDG238F','INDIGO',80,'MUMBAI','KANYAKUMARI','27-SEP-2017 4.00.00.000000 AM','27-SEP-2017 6.00.00.000000 AM'
		String mdept=request.getParameter("departure");
		String marr=request.getParameter("arrival");
		String mfare=request.getParameter("fare");
		String mcompany=request.getParameter("company");
		String mfid=request.getParameter("fid");
		String depttime=request.getParameter("depttime");
		String arrtime=request.getParameter("arrtime");
		String mseat=request.getParameter("seats");
		addflight v=new addflight();
		v.addflightdetails(mdept,marr,mseat,mcompany,mfid,depttime, arrtime);
		v.addfare(mfid,mfare);
		
		
	}

}
