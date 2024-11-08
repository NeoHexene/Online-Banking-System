package controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceImpl;
import service.ServiceInterface;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		String secques = request.getParameter("secques");
		String check;
		String password;

		
		try {
			ServiceInterface serviceInterface = new ServiceImpl();
			check = serviceInterface.getSecques(id);
			
			if (check.equals(secques)) {
				
				password = serviceInterface.getOldPassword(id);
				
				//HttpSession session = request.getSession();
				//session.setAttribute("Password", password);
				response.setContentType("text/html");
				response.getWriter().write("<h1>Your Password is: "+password+"</h1>");
				
			}
			else {
				response.sendRedirect("ForgetPass.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
