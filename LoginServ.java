

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
		String memail=request.getParameter("uemail");
		String mpass=request.getParameter("pass");
			// TODO Auto-generated method stub
		
		ValidateLogin v=new ValidateLogin();
		int out=v.r(memail,mpass);
		if(out==1){
			PW.println("<h2>Welcome</h2>");
			System.out.println("Valid login");
			PW.println("<br>Login Successful");
			PW.println("<br>Welcome user <b><i>"+memail+"</b></i>");
			PW.println("<br>Your password is <b><i>"+mpass+"</b></i>");
			PW.println("<br><br>Go back to <a href=Index.html>Booking Page</a>");
		}
		else{
			System.out.println("InValid Login Attempt");
			PW.println("<h4>INVALID LOGIN</h4>");
		}
		}// TODO Auto-generated method stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
