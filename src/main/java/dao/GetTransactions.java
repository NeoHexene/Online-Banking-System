/**
 * 
 */
package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;

/**
 * @author aniruddha.khandekar
 *
 */
public class GetTransactions {
	public List<Transaction> transactionsList (int id) {
		ResultSet rs = null;
		String query;
		Connection connection = GetCon.getConnection();
		PreparedStatement ps;
		List<Transaction> transactionList = new ArrayList<Transaction>();
		
		try {

			query = "select * from transaction where user_id = ? order by transaction_id desc";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setTransactionAmount(rs.getDouble("amount"));
				transaction.setTransactionDate(rs.getString("transaction_date"));
				transactionList.add(transaction);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionList;
	}
}
