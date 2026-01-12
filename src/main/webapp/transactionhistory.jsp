
<%@page import="model.Transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction History</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        h1 {
            background-color: #0056b3;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #0056b3;
            color: #fff;
        }
        tr:hover {
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
<form action="UserHome.html" method="post">
<input class="btn-primary" type="submit" value="Home" name="b1">
</form>
</div>
    <h1>Transaction History</h1>
    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Transaction Id</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Date&Time</th>
                </tr>
                 <% 
            List<Transaction> transaction = (List<Transaction>) session.getAttribute("TransactionHistory");
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
            <!-- <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${transaction.type}</td>
                        <td>${transaction.amount}</td>
                        <td>${transaction.date}</td>
                    </tr>
                </c:forEach>
            </tbody>-->
        </table>
    </div>
</body>
</html>


