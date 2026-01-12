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
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("PayServlet");

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Integer rid = Integer.parseInt(request.getParameter("receiverid"));
		double balance = 0, sum;

		HttpSession session = request.getSession();
		Integer id = (int) (session.getAttribute("id"));
		
		try {
			
			ServiceInterface serviceInterface = new ServiceImpl();
			balance = serviceInterface.getBalance(id);
			
			if (amount > balance || amount <=0 || rid == id) {
				//response.getWriter().write("Insufficient Balance");

				serviceInterface.transactionFail(id, amount);
				//response.sendRedirect("payment.html");
				
				response.sendRedirect("payfailed.html");
			}
			else {
				
				balance = balance - amount;

				serviceInterface.updateBalance(balance, id);

				serviceInterface.transactionDebit(id, amount);

				sum = serviceInterface.getBalance(rid);
				
				sum = sum + amount;

				serviceInterface.updateBalance(sum, rid);

				serviceInterface.transactionCredit(rid, amount);
				
				response.sendRedirect("paymentSuccessfull.html");
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

}
