/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author aniruddha.khandekar
 *
 */
public class GetCon {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DBIntializer.DRIVER);
			connection = DriverManager.getConnection(DBIntializer.CON_STRING, DBIntializer.USERNAME, DBIntializer.PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
