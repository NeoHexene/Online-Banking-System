package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.ServiceImpl;
import service.ServiceInterface;

/**
 * Servlet implementation class RemoveCustomer
 */
@WebServlet("/RemoveCustomer")
public class RemoveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer customerid = Integer.parseInt(request.getParameter("customerid"));

		try {

			try {
				HttpSession sessionAdmin = request.getSession();
				Integer id = (int) sessionAdmin.getAttribute("id");

				if (id != null) {
					ServiceInterface serviceInterface = new ServiceImpl();
					int result = serviceInterface.removeCustomer(customerid);

					if (result > 0) {
						response.getWriter().write("Removed Customer " + customerid);
						response.sendRedirect("Success.jsp");
					} else {
						response.getWriter().write("Error");
						response.sendRedirect("Failure.jsp");
					}
				} else {
					response.getWriter().write("<h1>You have already logged out</h1>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().write("<h1> You have already Logged out</h1>");
		}

	}

}
