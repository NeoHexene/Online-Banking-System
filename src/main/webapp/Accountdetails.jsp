
<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Details</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 50%;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 20px auto;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-left: 60px;
            margin-bottom: 20px;
          
        }

        td{
           width : 50%;
        }
        th {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        .trow{
        
        }

        th {
            font-weight: bold;
            background-color: #0056b3;
            color: #fff;
        }

        h1 {
            background-color: #0056b3;
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
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

 <%
			List<Customer> customer = (List<Customer>) session.getAttribute("UserDetails");
			int i = 0;
			while (i < customer.size()) {
				
			%>
			 <div class="buu1">
<form action="UserHome.html" method="post">
<input class="btn-primary" type="submit" value="Home" name="b1">
</form>
</div>
    <h1>Account Details</h1>
    <div class="container">
        <table>
        
            <tr>
                <th>Account Id</th>
               <td> <%=
					customer.get(i).getId()
					%>   </td>
            </tr>
            <tr>
                <th>Full Name</th>
                <td> <%=
					customer.get(i).getFullname()
					%>  </td>
            </tr>
            <tr>
                <th>Email</th>
                <td> <%=
					customer.get(i).getEmail()
					%>  </td>
            </tr>
            <tr>
                <th>Username</th>
                <td>  <%=
					customer.get(i).getUsername()
					%>  </td>
            </tr>
            <tr>
                <th>Address</th>
                <td> <%=
					customer.get(i).getAddress()
					%> </td>
            </tr>
            <tr>
                <th>Contact</th>
                <td> <%=
					customer.get(i).getContact()
					%>  </td>
            </tr>
            <tr>
                <th>Balance</th>
                <td> <%=
                customer.get(i).getBalance()
                %></td>
            </tr>
           		<%
				i++;
			}
			%>
			
        </table>
    </div>
</body>

</html>


