package test;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProfleServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c[] = req.getCookies();
		
		if(c==null) {
			req.setAttribute("msg", "Session expired...<br>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		}
		else {
			String fName = c[0].getValue();
			req.setAttribute("fname", fName);
			req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
		}
	}
}
