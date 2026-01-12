/**
 * 
 */
package model;

import java.io.Serializable;



/**
 * @author aniruddha.khandekar
 *
 */
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String password;
	private String address;
	private String contact;
	private double balance;
	private String email;
	private String fullname;
	private String secques;
	private String accountStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername () {
		return username;
	}
	public void setUsername (String username) {
		this.username = username;
	}
	public String getPassword () {
		return password;
	}
	public void setPassword (String password) {
		this.password = password;
	}
	public String getAddress () {
		return address;
	}
	public void setAddress (String address) {
		this.address = address;
	}
	public String getContact () {
		return contact;
	}
	public void setContact (String contact ) {
		this.contact = contact;
	}
	public void setBalance (double balance) {
		this.balance = balance;
	}
	public double getBalance () {
		return balance;
	}
	public void setEmail (String email) {
		this.email = email;
	}
	public String getEmail () {
		return email;
	}
	public void setFullname(String fullname) {
		// TODO Auto-generated method stub
		this.fullname = fullname;
	}
	public String getFullname () {
		return fullname;
	}
	public String getSecques() {
		return secques;
	}
	public void setSecques(String secques) {
		this.secques = secques;
	}
	public void setAccountStatus (String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccountStatus () {
		return accountStatus;
	}
}
