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
 * Servlet implementation class ViewCustomer
 */
@WebServlet("/ViewCustomer")
public class ViewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			HttpSession sessionAdmin = request.getSession();
			Integer id = (int) sessionAdmin.getAttribute("id");

		if (id!=null) {
			GetUserDetails gud = new GetUserDetails();
			
			int idc = Integer.parseInt(request.getParameter("id"));
			
			List<Customer> user = gud.userDetails(idc);
			
			System.out.println("Customer Details");
			System.out.println();
			for (Customer customer : user) {
				System.out.print(customer.getId()+" ");
				System.out.print(customer.getFullname()+" ");
				System.out.print(customer.getEmail()+" ");
				System.out.print(customer.getUsername()+" ");
				System.out.print(customer.getAddress()+" ");
				System.out.print(customer.getContact()+" ");
				System.out.print(customer.getBalance()+" ");
				System.out.print(customer.getAccountStatus());
				System.out.println();
			}
			response.sendRedirect("customerdetails.jsp");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			response.getWriter().write("<h1> You have already Logged out</h1>");
		}
	}

}
