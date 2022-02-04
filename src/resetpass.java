
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.passreset;

/**
 * Servlet implementation class resetpass
 */
@WebServlet("/resetpass")
public class resetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session1=request.getSession(true);
		PrintWriter PW = response.getWriter();
		String memail=request.getParameter("cmail");
		String mmob=request.getParameter("cmob");
		String muser=request.getParameter("cuser");
		session1.setAttribute("username",muser);
		
		 passreset v=new passreset();
		int count=v.returnpassword(memail,mmob,muser);
		
		if(count==1)
		{
		PW.println("<br> verification complete<br>");
		PW.println("<a href=passenter.jsp>Enter new password</a>");
	}

}
}

