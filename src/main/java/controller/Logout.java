package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			HttpSession session = request.getSession();
			@SuppressWarnings("unused")
			Integer id = (int) (session.getAttribute("id"));
			session.invalidate();
			response.sendRedirect("LoginPage.html");
			session = request.getSession(false);
		}
		catch (Exception e) {
			response.getWriter().write("<h1>You have already Logged Out.</h1>");
		}
	}

}
