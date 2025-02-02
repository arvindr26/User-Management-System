package test;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import  jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub = new UserBean();
		
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setMid(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k = new RegisterDAO().register(ub);
		System.out.println("Insert result: " + k);
		
		if(k>0) {
			req.setAttribute("msg", "user Register Successfully... <br>");
			
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, res);
		}else	{
			req.setAttribute("msg", "User registration failed. Please try again! <br>");
		}
	}

}
