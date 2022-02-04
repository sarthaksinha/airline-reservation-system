import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;
import com.model.FetchUserDetails;
import com.model.ValidateLogin;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
			
		String muser=request.getParameter("cuser");
		String mpass=request.getParameter("cpass");
		System.out.println(muser);
		System.out.println(mpass);
		
			// TODO Auto-generated method stub
		
		ValidateLogin v=new ValidateLogin();
		int out=v.r(muser,mpass);
		
        if(out==1)
        {  
    		HttpSession session =request.getSession(true);
    		session.setAttribute("username",muser);
    		session.setAttribute("password",mpass);
    		
    		FetchUserDetails v1 = new FetchUserDetails();
    		String details=v1.r(muser);
    		
        	PW.println("<br>You are successfully logged in!");  
        	PW.println("<br>Welcome, "+muser);  
        	
    		String[] parts = details.split(Pattern.quote(" "));
            String sname = parts[0];
            String sage = parts[1];
            String semail = parts[2];
            String smob = parts[3];
            
            session.setAttribute("CustName",sname);
            session.setAttribute("CustAge",sage);
            session.setAttribute("CustEmail",semail);
            session.setAttribute("CustMob",smob);
            
            response.sendRedirect("Index.jsp");
        }
        
        else
        {  
            System.out.print("sorry, username or password error!");  
            request.getRequestDispatcher("Login1.html").include(request, response);  
        }  
	
	
	
	
	}// TODO Auto-generated method stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
