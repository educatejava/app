package com.educatejava.app.vo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


/**
 * The Class User.
 */
public class User {

	/** The id. */
	@Id
	private String id;
	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The user books. */
	/** used Mongo DB reference concept which removes the redundancy **/
	@DBRef
	private List<Book> userBooks;
	
	//private String email;
	//private String firstName;
	//private String lastName;
	//private String name;
	//private String username;
	//private String mobileNo;
	//private int age;
	//private String address;
	//private String city;
	//private String state;
	//private String bookIds = "";
	//private Date creationTime;

	/**
	 * Instantiates a new user.
	 */
	public User() {}

	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param userBooks the user books
	 */
	public User(String userName, String password, List<Book> userBooks) {
		this.userName = userName;
		this.password = password;
		this.userBooks = userBooks;
	}

	
	

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	/**
	 * Gets the user books.
	 *
	 * @return the user books
	 */
	public List<Book> getUserBooks() {
		return userBooks;
	}

	/**
	 * Sets the user books.
	 *
	 * @param userBooks the new user books
	 */
	public void setUserBooks(List<Book> userBooks) {
		this.userBooks = userBooks;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userBooks=" + userBooks
				+ "]";
	}


}

