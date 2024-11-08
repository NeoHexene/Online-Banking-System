/**
 * 
 */
package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

/**
 * @author aniruddha.khandekar
 *
 */
public class GetUserDetails {
	public List<Customer> userDetails (int id) {
		ResultSet rs = null;
		String query;
		Connection connection = GetCon.getConnection();
		PreparedStatement ps;
		List<Customer> userDetails = new ArrayList<Customer>();
		
		try {

			query = "select * from bank where id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFullname(rs.getString("fullname"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setAddress(rs.getString("address"));
				customer.setContact(rs.getString("contact"));
				customer.setBalance(rs.getDouble("balance"));
				userDetails.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}
}
