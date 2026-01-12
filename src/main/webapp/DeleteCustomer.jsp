<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Delete Customer</title> 
    <style> 
        body { 
            font-family: Arial, sans-serif; 
        } 
        .container { 
            max-width: 500px; 
            margin: 0 auto; 
            padding: 40px; 
            position: static;
            border: 1px solid #ccc; 
            border-radius: 5px; 
            background-color: #f9f9f9; 
        } 
        .form-group { 
            margin-bottom: 20px; 
        } 
        .form-group label { 
            display: block; 
            font-weight: bold; 
        } 
        .form-group input[type="text"] { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ccc; 
            border-radius: 3px; 
        } 
        .form-group button { 
            background-color: #ff0000; 
            color: #fff; 
            border: none; 
            padding: 10px 20px; 
            cursor: pointer; 
        } 
        
        /* Style for the "Home" button */
        .buu1 { 
            margin-left: 83%;
            margin-top: -2%;
        }

        /* Style the "Home" button with Bootstrap styles */
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
<input class="btn-primary" type="submit" value="Home" name="b1">
</form>
</div>

    <div class="container">
        <h2>Delete Customer</h2>
        <form action="RemoveCustomer" method="post">
            <div class="form-group">
                <label for="customerID">Customer ID:</label>
                <input type="text" id="customerID" name="customerid" required>
            </div>
            <!-- Add more form fields as needed -->
            <div class="form-group">
                <button type="submit">Delete Customer</button>
            </div>
        </form>
    </div>
    
   <%--  <%
        // Assuming you have a Java class (e.g., CustomerService) to handle database operations

        // Retrieve the customer ID from the form
        String customerID = request.getParameter("customerID");

        // Check if the user exists in the database and was deleted successfully
        boolean deletedSuccessfully = CustomerService.deleteCustomer(customerID);

        // Redirect to success.jsp or failure.jsp based on the result
        if (deletedSuccessfully) {
            response.sendRedirect("Success.jsp");
        } else {
            response.sendRedirect("Failure.jsp");
        }
    %> --%>
</body>
</html>