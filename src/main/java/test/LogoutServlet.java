package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		Cookie c[] = req.getCookies();
		if(c==null) {
			req.setAttribute("msg", "Session expired...<br>");
		}else {
			
			c[0].setMaxAge(0);
			res.addCookie(c[0]);
			req.setAttribute("msg", "User Loged out Successfully...");
		}
		req.getRequestDispatcher("Fail.jsp").forward(req, res);
	}
}
