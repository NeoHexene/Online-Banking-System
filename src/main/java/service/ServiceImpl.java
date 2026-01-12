/**
 * 
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import dao.GetCon;

/**
 * @author aniruddha.khandekar
 *
 */
public class ServiceImpl implements ServiceInterface {
	
	ResultSet rs;
	String query;
	Connection connection = GetCon.getConnection();
	PreparedStatement ps;

	@Override
	public ResultSet checkCustomer(String email) {
		
		try {
			query = "select username from bank where email = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	@Override
	public ResultSet validateCustomer(String username, String password) {
		try {
			query = "select accountstatus from bank where username = ? and password = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
//			rs.next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet getCustomerID(String username, String password) {
		
		try {
			query = "select id from bank where username = ? and password = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public String getOldPassword(int id) {
		String old = "";
		try {
			query = "select password from bank where id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			old = rs.getString("password");
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return old;
		
	}

	@Override
	public void updatePassword(String password, int id) {
		
		try {
			connection.setAutoCommit(true);
			query = "update bank set password = ? where id = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.execute();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public String getSecques(int id) {
		String check = "";
		try {
			query = "select secques from bank where id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			check = rs.getString("secques");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return check;
		
	}

	@Override
	public void transactionFail(int id, double amount) {
		
		try {
			connection.setAutoCommit(true);
			query = "insert into transaction (user_id, transaction_type, amount, transaction_date) values (?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, "Failed");
			ps.setDouble(3, amount);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.execute();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public double getBalance(int id) {
		double balance = 0;
		try {
			query = "select balance from bank where id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			balance = rs.getDouble("balance");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
		
	}

	@Override
	public void transactionCredit(int id, double amount) {
		
		try {
			connection.setAutoCommit(true);
			query = "insert into transaction (user_id, transaction_type, amount, transaction_date) values (?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, "Credit");
			ps.setDouble(3, amount);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.execute();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void transactionDebit(int id, double amount) {
		
		try {
			connection.setAutoCommit(true);
			query = "insert into transaction (user_id, transaction_type, amount, transaction_date) values (?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, "Debited");
			ps.setDouble(3, amount);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.execute();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateBalance(double balance, int id) {
		
		try {
			connection.setAutoCommit(true);
			query = "update bank set balance = ? where id = ?";
			ps = connection.prepareStatement(query);
			ps.setDouble(1, balance);
			ps.setInt(2, id);
			ps.execute();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public int removeCustomer(int id) {
		int result = 0;
		try {
			connection.setAutoCommit(true);
			query = "update bank set accountstatus = ? where id = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, "Closed");
			ps.setInt(2, id);
			result = ps.executeUpdate();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
		
	}

}
