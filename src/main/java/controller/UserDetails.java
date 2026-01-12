package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GetUserDetails;
import model.Customer;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Integer id = (int) (session.getAttribute("id"));
		
		GetUserDetails gud = new GetUserDetails();
		
		List<Customer> user = gud.userDetails(id);
		
		session.setAttribute("UserDetails", user);
		System.out.println("User Details");
		System.out.println();
		for (Customer customer : user) {
			System.out.print(customer.getId()+" ");
			System.out.print(customer.getFullname()+" ");
			System.out.print(customer.getEmail()+" ");
			System.out.print(customer.getUsername()+" ");
			System.out.print(customer.getAddress()+" ");
			System.out.print(customer.getContact()+" ");
			System.out.print(customer.getBalance());
			System.out.println();
		}
		response.sendRedirect("Accountdetails.jsp");
	}
}
