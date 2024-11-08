
<%@page import="model.Transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show All Transactions</title>
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
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
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
    </style>
</head>
<body>
<div class="buu1">
<form action="AdminDash.jsp" method="post">
<input class="btn-primary" type="submit" value="Home" name="b1">
</form>
</div>
    <h2>Show All Transactions</h2>
    
    <table>
        <thead>
            <tr>
                <th >ID</th>
                <th>User ID</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
            <% 
            List<Transaction> transaction = (List<Transaction>) session.getAttribute("TransactionDetails");
			int i = 0;
			System.out.println("showTransactions jsp");
			System.out.println(transaction.size());
			while (i < transaction.size()) {
				System.out.println("Inside while");
			%>
			<tr>
				<td>
					<%=
					transaction.get(i).getTransactionId()
					%>
				</td>
				<td>
					<%=
					transaction.get(i).getUserId()
					%>
				</td>
				<td>
					<%=
					transaction.get(i).getTransactionType()
					%>
				</td>
				<td>
					<%=
					transaction.get(i).getTransactionAmount()
					%>
				</td>
				<td>
					<%=
					transaction.get(i).getTransactionDate()
					%>
				</td>
			</tr>
			<%
				i++;
			}
			%>
        </thead>
        <tbody>
            <%-- Java code to fetch and display transactions from the database --%>
          <%--   <%
                // Assuming you have a Java class to fetch transaction data from the database
                List<Transaction> transactions = TransactionDAO.getAllTransactions(); // Modify this to fetch data from your database

                // Loop through the transaction list and populate the table rows
                for (Transaction transaction : transactions) {
            %> --%>
           <%--  <tr>
                <td><%= transaction.getCustomerId() %></td>
                <td><%= transaction.getCustomerName() %></td>
                <td><%= transaction.getTransactionDetails() %></td>
            </tr>
            <%
                }
            %>
            End of Java code --%>
        </tbody>
    </table>
</body>
</html>