package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GetTransactions;
import model.Transaction;

/**
 * Servlet implementation class TransactionHistory
 */
@WebServlet("/TransactionHistory")
public class TransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("WithdrawServlet");

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Integer id = (int) (session.getAttribute("id"));
		
		GetTransactions gt = new GetTransactions() ;
		
		List<Transaction> transactions  = gt.transactionsList(id);	
		
		session.setAttribute("TransactionHistory", transactions);
		System.out.println("Transaction History");
		System.out.println();
		for (Transaction transaction : transactions) {
			System.out.print(transaction.getTransactionId()+" ");
			System.out.print(transaction.getTransactionType()+" ");
			System.out.print(transaction.getTransactionAmount()+" ");
			System.out.print(transaction.getTransactionDate());
			System.out.println();
		}
		
		response.sendRedirect("transactionhistory.jsp");
		
	}

}
