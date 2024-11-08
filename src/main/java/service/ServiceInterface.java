/**
 * 
 */
package service;

import java.sql.ResultSet;

/**
 * @author aniruddha.khandekar
 *
 */
public interface ServiceInterface {
	
	public ResultSet checkCustomer (String email); // add customer
	public ResultSet validateCustomer (String username, String password);
	public ResultSet getCustomerID (String username, String password); // after login
	public String getOldPassword (int id); // change password, forgot password
	public void updatePassword (String password, int id); // change password
	public String getSecques (int id); // forgot password
	public void transactionFail (int id, double amount); // deposit, withdraw, pay
	public double getBalance (int id); // withdraw, pay, deposit
	public void transactionCredit (int id, double amount); // deposit, receive
	public void transactionDebit (int id, double amount); // withdraw, pay
	public void updateBalance (double balance, int id); // pay, withdraw, deposit
	public int removeCustomer (int id); // remove customer
}
