package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GettAllTransactions;
import model.Transaction;

/**
 * Servlet implementation class AllTransactions
 */
@WebServlet("/AllTransactions")
public class AllTransactions extends HttpServlet {
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
			GettAllTransactions gat = new GettAllTransactions();
			
			List<Transaction> transactions = gat.allTransactions();
			
			HttpSession session = request.getSession();
			session.setAttribute("TransactionDetails", transactions);
			System.out.println("All Transactions");
			System.out.println();
			for (Transaction transaction : transactions) {
				System.out.print(transaction.getTransactionId()+" ");
				System.out.print(transaction.getUserId()+" ");
				System.out.print(transaction.getTransactionType()+" ");
				System.out.print(transaction.getTransactionAmount()+" ");
				System.out.print(transaction.getTransactionDate());
				System.out.println();
			}
			response.sendRedirect("ShowTransactions.jsp");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			response.getWriter().write("<h1> You have already Logged out</h1>");
		}
	}

}
