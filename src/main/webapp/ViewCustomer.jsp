<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>List of Customers</title> 
    <style> 
        body { 
            font-family: Arial, sans-serif; 
        } 
        table { 
            width: 80%; 
            margin: 20px auto; 
            border-collapse: collapse; 
        } 
        table, th, td { 
            border: 1px solid #ccc; 
        } 
        th, td { 
            padding: 10px; 
            text-align: left; 
        } 
        th { 
            background-color: #f2f2f2; 
        } 
        
          .buu1{
             
    margin-left: 83%;
    margin-top: -2%;
}

 .btn-primary {
            color: #fff;
            background-color: #337ab7;
            border-color: #2e6da4;
             margin-left: 0%;
            margin-top: 20%;
          
            
        }
        
    </style> 
</head> 
<body> 
 <div class="buu1">
        <form action="AdminDash.jsp" method="post">
            <input class="btn btn-primary" type="submit" value="Home" name="b1">
        </form>
    </div>
    <h2>List of Customers</h2> 
    <table> 
        <thead> 
            <tr> 
                <th>Customer ID</th> 
                <th>Full Name</th> 
                <th>Email</th>
                <th>Username</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Balance</th>
                <th>Account Status</th>
                <!-- Add more table headers for additional customer details --> 
            </tr> 
            <%
			List<Customer> customer =  (List<Customer>)session.getAttribute("CustomersDetails");
			int i = 0;
			System.out.println("viewCustomers jsp");
			System.out.println(customer.size());
			while (i < customer.size()) {
				System.out.println("Inside while");
			%>
			<tr>
				<td>
					<%=
					customer.get(i).getId()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getFullname()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getEmail()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getUsername()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getAddress()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getContact()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getBalance()
					%>
				</td>
				<td>
					<%=
					customer.get(i).getAccountStatus()
					%>
				</td>
			</tr>
			<%
				i++;
			}
			%>
        </thead> 
        <tbody> 
          <%--   <% 
                // Assuming you have a Java class to fetch customer data from the database
                List<Customer> customers = CustomerDAO.getAllCustomers(); // Modify this to fetch data from your database
                
                // Loop through the customer list and populate the table rows
                for (Customer customer : customers) {
            %>  --%>
          <%--   <tr> 
                <td><%= customer.getCustomerId() %></td> 
                <td><%= customer.getFullName() %></td> 
                <td><%= customer.getEmail() %></td>
                <td><%= customer.getUsername() %></td>
                <td><%= customer.getAddress() %></td>
                <td><%= customer.getContact() %></td>
                <td><%= customer.getBalance() %></td>
                <td><%= customer.getAccountStatus() %></td>
                <!-- Add more table cells for additional customer data --> 
            </tr>  --%>
         <%--    <% 
                }
            %>  --%>
            <!-- Add more rows for additional customers --> 
        </tbody> 
    </table> 
</body> 
</html>