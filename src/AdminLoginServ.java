

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ValidateAdmin;
import com.model.ValidateLogin;

/**
 * Servlet implementation class AdminLoginServ
 */
@WebServlet("/AdminLoginServ")
public class AdminLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
			
		String muser=request.getParameter("auser");
		String mpass=request.getParameter("apassword");
		System.out.println(muser);
		System.out.println(mpass);
		
			// TODO Auto-generated method stub
		
		ValidateAdmin a=new ValidateAdmin();
		int out=a.r(muser,mpass);
		
        if(out==1)
        {  
    		HttpSession session =request.getSession(true);
    		session.setAttribute("adminname",muser);
    		session.setAttribute("adminpassword",mpass);
    		
        	PW.println("<br>You are successfully logged in!");  
        	PW.println("<br>Welcome, "+muser);  
            response.sendRedirect("adminindex.jsp");
        }
        
        else
        {  
            System.out.print("sorry, username or password error!");  
            response.sendRedirect("AdminLogin.html");  
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
