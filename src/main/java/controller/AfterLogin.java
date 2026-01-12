package controller;

import java.io.IOException;

import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceImpl;
import service.ServiceInterface;

/**
 * Servlet implementation class AfterLogin
 */
@WebServlet("/AfterLogin")
public class AfterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("admin") && password.equals("admin@admin")) {
			response.getWriter().write("WELCOME ADMIN");
			ServiceInterface serviceInterface = new ServiceImpl();
			ResultSet rs = serviceInterface.getCustomerID(username, password);

			try {
				if (rs.next()) {
					int id = rs.getInt("id");
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					response.sendRedirect("AdminDash.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				ServiceInterface serviceInterface = new ServiceImpl();
				ResultSet rs = serviceInterface.getCustomerID(username, password);

				if (rs.next()) {
					rs = serviceInterface.validateCustomer(username, password);
					rs.next();
					if (rs.getString("accountstatus").equals("Closed")) {
						response.sendRedirect("ClosedAccount.html");
					} else {

						rs = serviceInterface.getCustomerID(username, password);
						rs.next();
						int id = rs.getInt("id");
						HttpSession session = request.getSession();
						session.setAttribute("id", id);
						response.sendRedirect("UserHome.html");
					}

				} else {
					response.sendRedirect("LoginFail.html");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
