package com.educatejava.app.vo;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * The Class Barrower.
 */
public class Barrower {

	
	/** The id. */
	@Id
	private Integer id;
	
	/** The user name. */
	private String userName;
	
	/** The book title. */
	private String bookTitle;
	
	/** The checked out date. */
	private Date checkedOutDate;
	
	/** The return date. */
	private Date returnDate;
	
	/**
	 * Instantiates a new barrower.
	 *
	 * @param id the id
	 * @param userName the user name
	 * @param bookTitle the book title
	 * @param checkedOutDate the checked out date
	 * @param returnDate the return date
	 */
	public Barrower(Integer id, String userName, String bookTitle, Date checkedOutDate, Date returnDate) {
		this.id = id;
		this.userName = userName;
		this.bookTitle = bookTitle;
		this.checkedOutDate = checkedOutDate;
		this.returnDate = returnDate;
	}

	

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
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
	 * Gets the book title.
	 *
	 * @return the book title
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * Sets the book title.
	 *
	 * @param bookTitle the new book title
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * Gets the checked out date.
	 *
	 * @return the checked out date
	 */
	public Date getCheckedOutDate() {
		return checkedOutDate;
	}

	/**
	 * Sets the checked out date.
	 *
	 * @param checkedOutDate the new checked out date
	 */
	public void setCheckedOutDate(Date checkedOutDate) {
		this.checkedOutDate = checkedOutDate;
	}

	/**
	 * Gets the return date.
	 *
	 * @return the return date
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Sets the return date.
	 *
	 * @param returnDate the new return date
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Barrower [id=" + id + ", userName=" + userName + ", bookTitle=" + bookTitle + ", checkedOutDate="
				+ checkedOutDate + ", returnDate=" + returnDate + "]";
	}
	
	
}
