

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Hashing;
import com.model.passreset;

/**
 * Servlet implementation class enterpass
 */
@WebServlet("/enterpass")
public class enterpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enterpass() {
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
		String password=request.getParameter("cpassword");
		String muser=(String)session1.getAttribute("username");
		
		Hashing m = new Hashing();
        String spassword = m.md5(password);

		 passreset v=new passreset();
		int count=v.newpass(spassword,muser);
		if(count==1)
		{
		
		PW.println("Password change successful. Since your password has been reset, you need to login again. <form action=Logout><input type=submit value='Go to home'></form>");
	}
	}

	
}
