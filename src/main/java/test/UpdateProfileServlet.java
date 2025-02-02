package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c[] = req.getCookies();
		
		if(c==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		}
		else {
			String fName = c[0].getValue();
			req.setAttribute("fname", fName);
			UserBean ub = (UserBean)req.getServletContext().getAttribute("ubean");
			ub.setAddr(req.getParameter("addr"));
			ub.setMid(req.getParameter("mid"));
			ub.setPhno(Long.parseLong(req.getParameter("phno")));
			
			int k = new UpdateProfileDAO().update(ub);
			
			if(k>0) {
				req.setAttribute("msg", "Profile Update Successfully...<br>");
				req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			}
		}
	}

}
