package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterUsers;
import model.Customer;
import service.ServiceImpl;
import service.ServiceInterface;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger("AddCustomer");

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String secques = request.getParameter("secques");
		Double balance = 0.00;
		String accountStatus = "Active";
		
		if (contact.length() != 10 || contact.charAt(0) == 0) {
			response.sendRedirect("signup.html");
			logger.info("Contact must be 10 digits");
		} else if (!email.contains("@")) {
			response.sendRedirect("signup.html");
			logger.info("EmailID must contain '@'");
		}
		else if (username.equalsIgnoreCase("admin") || password.equalsIgnoreCase("admin@admin") || email.equalsIgnoreCase("admin@admin.com")) {
			response.sendRedirect("signup.html");
		}
		else 
		{
			try {
				ServiceInterface serviceInterface = new ServiceImpl();
				ResultSet rs = serviceInterface.checkCustomer(email);
				if (rs.next()) {
					response.sendRedirect("index.html");
				}
				else {
					Customer customer = new Customer();

					customer.setFullname(fullname);
					customer.setEmail(email);
					customer.setUsername(username);
					customer.setPassword(password);
					customer.setAddress(address);
					customer.setContact(contact);
					customer.setSecques(secques);
					customer.setBalance(balance);
					customer.setAccountStatus(accountStatus);
					int result = -1;

					try {
						RegisterUsers registerUsers = new RegisterUsers();
						result = registerUsers.registerUser(customer);
					} catch (Exception e) {
						e.printStackTrace();
					}

					response.setContentType("text/html");

					if (result > 0) {
						response.getWriter().write("<h3> Registered User " + username + "</h3>");
						response.sendRedirect("registersuc.html");
					} 
					else {
						response.getWriter().write("<h3> Error in Registering " + username + "</h3>");
						response.sendRedirect("failregister.html");
					}
				}
			}
			catch (Exception e) {
				e.getStackTrace();
			}
	
		}
	}

}
