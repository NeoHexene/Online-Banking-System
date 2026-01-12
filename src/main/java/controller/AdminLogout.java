package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession sessionAdmin = request.getSession();
			@SuppressWarnings("unused")
			Integer id = (int)sessionAdmin.getAttribute("id");
			sessionAdmin.invalidate();
			response.sendRedirect("LoginPage.html");
			response.getWriter().write("<h1>You have successfully Logged Out.</h1>");
		}
		catch (Exception e) {
			response.getWriter().write("<h1>You have already Logged Out.</h1>");
		}
	}

}
