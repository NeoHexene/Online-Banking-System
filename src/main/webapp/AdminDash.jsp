<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        .jumbotron {
            text-align: center;
            background-color: rgb(31, 149, 204);
        }

        .container {
            text-align: center;
        }

       /*  a.button {
            padding: 50px 20px;
            background-color: #3287f4;
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.3s ease;
        } */
        
        a.button {
    padding: 20px 10px;
    background-color: #3287f4;
    border: none;
    color: white;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 10px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
}

        a.button:hover {
            background-color: #2969b0; /* Change color on hover */
            transform: scale(1.1); /* Add a slight zoom effect on hover */
        }

        .buu1 {
            margin-left: 83%;
            margin-top: -2%;
        }

        .buu2 {
            margin-left: 66%;
            margin-top: -2%;
        }
    </style>
</head>
<body style="background-color: #f3f6f7;">

<div class="jumbotron">
    <h1 style="color: white;">Welcome Admin!</h1>

    <div class="buu1">
        <form action="AdminLogout" method="post">
            <input class="btn btn-primary" type="submit" value="LogOut" name="b1">
        </form>
    </div>
    <div class="buu2">
        <!-- <form action="AdminHome.jsp" method="post">
           <input class="btn btn-primary" type="submit" value="Home" name="b1">
       </form> -->
    </div>
</div>

<div class="container">
    <h2>Select any option </h2>
    <h3>
        <!--<a href="CancelStatement.jsp">Customer<br>Statement</a>-->
        <a class="button" href="AllCustomerDetails">View<br>Customer</a>
        <a class="button" href="AllTransactions">Show <br>Transactions</a>
        <!--  <a href="ShowCustomers.jsp">Show <br>Customers</a><!--  -->
        <a class="button" href="DeleteCustomer.jsp">Delete<br>Customer</a>
    </h3>
</div>
</body>
