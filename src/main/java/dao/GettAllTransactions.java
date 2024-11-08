/**
 * 
 */
package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Transaction;

/**
 * @author aniruddha.khandekar
 *
 */
public class GettAllTransactions {
	public List<Transaction> allTransactions () {
		ResultSet rs = null;
		String query;
		Connection connection = GetCon.getConnection();
		Statement st = null;
		List<Transaction> allTransactionDetails = new ArrayList<Transaction>();
		
		try {
			
			st = connection.createStatement();
			query = "select * from transaction order by transaction_id desc"; // not to add admin in the result set (id != 1)
			rs = st.executeQuery(query);

			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setUserId(rs.getInt("user_id"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setTransactionAmount(rs.getDouble("amount"));
				transaction.setTransactionDate(rs.getString("transaction_date"));
				allTransactionDetails.add(transaction);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTransactionDetails;
	}
}
