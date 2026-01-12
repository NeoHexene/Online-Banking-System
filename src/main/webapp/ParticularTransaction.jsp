<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Customer Transactions</title> 
    <style> 
        body { 
            font-family: Arial, sans-serif; 
        } 
        .container { 
            max-width: 400px; 
            margin: 0 auto; 
            padding: 40px; 
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
            background-color: #007bff; 
            color: #fff; 
            border: none; 
            padding: 10px 20px; 
            cursor: pointer; 
        } 
          .buu1{
             
    margin-left: 83%;
    margin-top: -2%;
}

.btn-primary {
    color: #fff;
    background-color: #337ab7;
    border-color: #2e6da4;
}
    </style> 
</head> 
<body> 
    <div class="container"> 
        <h2>Customer Transactions</h2> 
        <div class="buu1">
        <form action="AdminDash.jsp" method="post">
            <input class="btn btn-primary" type="submit" value="Home" name="b1">
       </form>
        </div>
        
        <form action="DisplayTransaction.jsp" method="post"> 
            <div class="form-group"> 
                <label for="customerID">Customer ID:</label> 
                <input type="text" id="customerID" name="customerID" required> 
            </div> 
            <div class="form-group"> 
                <button type="submit" >Show Transactions</button> 
            </div> 
        </form> 
    </div> 
</body> 
</html>