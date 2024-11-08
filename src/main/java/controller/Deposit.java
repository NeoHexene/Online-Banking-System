package controller;

import java.io.IOException;


import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.ServiceImpl;
import service.ServiceInterface;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("DepositServlet");

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		double balance = 0;
		
		HttpSession session = request.getSession();
		Integer id = (int) (session.getAttribute("id"));
		
		ServiceInterface serviceInterface = new ServiceImpl();

		try {

			if (amount <= 0) {
				response.getWriter().write("Amount can't be zero or negative");
				serviceInterface.transactionFail(id, amount);
				response.sendRedirect("depfail.html");

			} 
			else {
				balance = serviceInterface.getBalance(id);
				
				balance = balance + amount;
				
				serviceInterface.updateBalance(balance, id);

				serviceInterface.transactionCredit(id, amount);
				
				response.sendRedirect("depsuccess.html");


				logger.info("Done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
