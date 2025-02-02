package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String uN = req.getParameter("uname");
		String pW = req.getParameter("pword");
		UserBean ub = new LoginDAO().login(uN, pW);
		
		if(ub==null) {
			req.setAttribute("msg", "Invalid Loging process...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Fail.jsp");
			rd.forward(req, res);
		}
		else {
			ServletContext sct = req.getServletContext();
			// Accessing ServletContext-Object reference
			
			sct.setAttribute("ubean", ub);
			//Adding Bean to ServletContext
			
			Cookie ck = new Cookie("fname", ub.getfName());
			res.addCookie(ck);//Adding Cookie to response
			
			RequestDispatcher rd = req.getRequestDispatcher("LogSuccess.jsp");
			rd.forward(req, res);
			
		}
	}
}
