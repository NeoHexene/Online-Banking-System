/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

/**
 * @author aniruddha.khandekar
 *
 */
public class GetAllCustomers {
	public List<Customer> allCustomers () {
		ResultSet rs = null;
		String query;
		Connection connection = GetCon.getConnection();
		Statement st = null;
		List<Customer> allCustomerDetails = new ArrayList<Customer>();
		
		try {
			
			st = connection.createStatement();
			query = "select * from bank order by id asc";
			rs = st.executeQuery(query);

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFullname(rs.getString("fullname"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
				customer.setAddress(rs.getString("address"));
				customer.setContact(rs.getString("contact"));
				customer.setBalance(rs.getDouble("balance"));
				customer.setAccountStatus(rs.getString("accountstatus"));
				allCustomerDetails.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCustomerDetails;
	}
}
