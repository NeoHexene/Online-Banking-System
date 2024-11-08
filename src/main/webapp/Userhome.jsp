<%
try {
	session.invalidate();
	session = request.getSession(false);
	response.sendRedirect("LoginPage.html");	
}
catch (Exception e) {
	out.write("Logged Out");
}
%>
