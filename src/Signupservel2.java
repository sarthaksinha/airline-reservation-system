import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Hashing;

/**
 * Servlet implementation class Signupservel2
 */
@WebServlet("/Signupservel2")
public class Signupservel2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupservel2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //PrintWriter PW=response.getWriter();
                     response.setContentType("text/html");
                     String mname=request.getParameter("cname");
                     String memail=request.getParameter("cmail");
                     String mpassword=request.getParameter("cpassword");
                     String mmob=request.getParameter("cmob");
                     String mage=request.getParameter("cage");
                     
                     HttpSession session1=request.getSession(true);
                     String muser=(String)session1.getAttribute("username");
                     Hashing m = new Hashing();
                     String spassword = m.md5(mpassword);
                     System.out.println(muser);
                     
                     Databasejdbc r = new Databasejdbc();
                     r.InsertData(muser,mname,mage,memail,mmob,spassword);
                     
                     response.sendRedirect("Login1.html");
 }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
