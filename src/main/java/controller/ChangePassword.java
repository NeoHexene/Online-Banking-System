package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.ServiceImpl;
import service.ServiceInterface;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Integer id = (int)(session.getAttribute("id"));
		
		String oldPassword = request.getParameter("oldpassword");
		String newPassword = request.getParameter("newpassword");
		String confirmPassword = request.getParameter("confirmpassword");
		String old;
		
		try {
			ServiceInterface serviceInterface = new ServiceImpl();
			
			old = serviceInterface.getOldPassword(id);
			
			if ((!newPassword.equals(confirmPassword)) || (!old.equals(oldPassword))) {
				response.sendRedirect("ForgetPass.html");
			}
			else {
				serviceInterface.updatePassword(newPassword, id);
				response.sendRedirect("changedPasswordSuc.html");
			}	
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}

}
