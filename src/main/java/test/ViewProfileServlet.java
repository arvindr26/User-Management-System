package test;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Getting Cookie from Request Object
		Cookie c[] = req.getCookies();
		
		if(c==null) {
			req.setAttribute("msg", "Session expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
		}
		else {
			
			String fN = c[0].getValue();
			req.setAttribute("fName", fN);
			
			RequestDispatcher rd = req.getRequestDispatcher("ViewProfile.jsp");
			rd.forward(req, res);
		}
		
	}

}
