<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Transaction History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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
    </style>
</head>
<body>
  <div class="container">
    <h2>Customer Transaction History</h2>

   <%--  <%
        // Import necessary Java classes for database access
        // Import your custom classes as needed

        // Retrieve the customer ID from the previous form
        String customerID = request.getParameter("customerID");

        // Perform database query to retrieve transaction history for the customer
        // Replace the following lines with your actual database access code
        List<Transaction> transactions = TransactionDAO.getTransactionHistory(customerID);

        if (transactions.isEmpty()) {
    %>
    <p>No transaction history found for the customer with ID <%= customerID %>.</p>
    <%
        } else {
            // Create a unique file name for this customer's transaction history
            String fileName = "customer_" + customerID + "_transactions.html";

            // Create and write the transaction history to a separate HTML file
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>Customer Transaction History</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h2>Transaction History for Customer ID: " + customerID + "</h2>");
            printWriter.println("<table>");
            printWriter.println("<tr>");
            printWriter.println("<th>Transaction ID</th --%>