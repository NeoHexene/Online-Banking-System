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
 * Servlet implementation class Withdraw
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("WithdrawServlet");
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		double balance = 0;

		HttpSession session = request.getSession();
		Integer id = (int) (session.getAttribute("id"));

		try {
			ServiceInterface serviceInterface = new ServiceImpl();
			balance = serviceInterface.getBalance(id);


			if (amount > balance || amount <=0) {
				response.getWriter().write("Insufficient Balance");

				serviceInterface.transactionFail(id, amount);
				response.sendRedirect("Withdrawfail.html");
			} 
			else {
				
				balance = balance - amount;

				serviceInterface.updateBalance(balance, id);

				serviceInterface.transactionDebit(id, amount);
				
				response.sendRedirect("Withdrawsuccess.html");

				logger.info("Done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
