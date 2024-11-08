/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import model.Customer;

/**
 * @author aniruddha.khandekar
 *
 */
public class RegisterUsers implements DBIntializer {
	public int registerUser (Customer customer) {
		int result = 0;
		try {
			
			Connection connection = GetCon.getConnection();
			PreparedStatement ps ;
			
			connection.setAutoCommit(true);
			String query = "insert into bank (fullname, email, username, password, address, contact, secques, balance, accountstatus) values (?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(query);
			
			ps.setString(1, customer.getFullname());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getUsername());
			ps.setString(4, customer.getPassword());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getContact());
			ps.setString(7, customer.getSecques());
			ps.setDouble(8, customer.getBalance());
			ps.setString(9, customer.getAccountStatus());
			result = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
