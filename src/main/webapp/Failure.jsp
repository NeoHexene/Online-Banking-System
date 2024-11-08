<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Customer Failure</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        h2 {
            color: #ff0000;
        }

        p {
            color: #555;
        }

        /* Style your links or buttons here if needed */
        a {
             display: inline-block;
            padding: 9px 10px;
            background-color: #ff0000;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        /* Style a button if needed */
        .button {
            display: inline-block;
            padding: 9px 10px;
            background-color: #ff0000;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
 .buu1{
  margin-left:83%;
  margin-top:-2;
  color:blue;
  }
  
  .btn-primary{
  color:#337ab7;
  margin-left:0%;
  margin-top:20%;
  padding:10px 20px;
  }

        /* You can add more styles as per your design requirements */
    </style>
</head>
<body>
<div class="buu1">
<form action="AdminDash.jsp" method="post">
<input class="btn-primary" type="submit" value="Home" name="b1">
</form>
</div>

    <div class="container">
        <h2>Delete Customer Failure</h2>
        <p>The customer with the provided ID was not found in the database, or there was an error.</p>
        <!-- You can include links or buttons here to go back to the previous page or take other actions if needed. -->
        <a href="DeleteCustomer.jsp">Try Again</a>
       <!--  <button class="button">Try Again</button> -->
    </div>
</body>
</html>