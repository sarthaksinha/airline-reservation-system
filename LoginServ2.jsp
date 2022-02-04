<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
    <%@ page import="com.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>
body
{
background-image: url("airplane.jpg");
 background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    font-family: sans-serif;
    font-size: 20px;
}
			
	.button  { 
    			border: none;
			border-radius: 4px;
   			color: black;
    			padding: 8px 50px;
    			text-align: center;
    			text-decoration: none;
    			display: inline-block;
    			font-size: 18px;
    			margin: 4px 2px;
    			cursor: pointer;
    			-webkit-transition-duration: 0.4s; /* Safari */
    			transition-duration: 0.4s;
		}

    .button {
    background-color: white; 
    color: black; 
    border: 2px solid black;;
}

.button:hover {
    background-color: black;
    color: white;
}

.container
{
opacity:0.75;
}





input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 0.5px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}


input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 18px;
}
 }
</head>
<body>
<% response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		HttpSession session1 =request.getSession(true);
		
		String muser=request.getParameter("cuser");
		String mpass=request.getParameter("cpass");
		
		String flightid=(String)session.getAttribute("flightid");
		
		System.out.println(flightid);
			// TODO Auto-generated method stub
		
		ValidateLogin v=new ValidateLogin();
		int ou=v.r(muser,mpass);
	
        if(ou==1)
        {  
    		session.setAttribute("username",muser);
    		session.setAttribute("password",mpass);
    		
        	PW.println("<br>You have successfully logged in!");  
        	PW.println("<br>Welcome, "+muser+""
        			+ "<form action=Radio2 method=get>"
        			+ "<input type=submit value=Proceed to your booking>");  
        }
        
        else
        {  
            System.out.print("sorry, username or password error!");  
            request.getRequestDispatcher("Login2.html").include(request, response);  
        }  %>
	
	
</body>
</html>