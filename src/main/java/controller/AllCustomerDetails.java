package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.GetAllCustomers;

import model.Customer;


/**
 * Servlet implementation class AllCustomerDetails
 */
@WebServlet("/AllCustomerDetails")
public class AllCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			HttpSession sessionAdmin = request.getSession();
			Integer id = (int) sessionAdmin.getAttribute("id");

		if (id!=null) {
			GetAllCustomers gac = new GetAllCustomers();

			List<Customer> customers = gac.allCustomers();
			
			HttpSession session = request.getSession();
			session.setAttribute("CustomersDetails", customers);
			System.out.println("All Customers");
			System.out.println();
			for (Customer customer : customers) {
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
			response.sendRedirect("ViewCustomer.jsp");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			response.getWriter().write("<h1> You have already Logged out</h1>");
		}
	}

}
