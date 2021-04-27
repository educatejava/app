package com.educatejava.app.vo;

import org.springframework.data.annotation.Id;

/**
 * The Class Book.
 */
public class Book {

	/** The id. */
	@Id
	private Integer id;
	
	/** The title. */
	private String title;
	
	/** The author. */
	private String author;
	
	/** The publisher. */
	private String publisher;
	
	/** The description. */
	private String description;
	
	/** The image url. */
	private String imageUrl;
	
	/** The checked out. */
	private Boolean checkedOut;
	
	/** The pages. */
	private Integer pages;
	// id, title, author, year, publisher, description, category, imageUrl, rating

	// private String isbn;
	// private String year;
	// private String language;
	// private String category;
	// private String rating;

	/**
	 * Instantiates a new book.
	 */
	public Book() {
	}

	/**
	 * Instantiates a new book.
	 *
	 * @param id the id
	 * @param title the title
	 * @param author the author
	 * @param publisher the publisher
	 * @param description the description
	 * @param imageUrl the image url
	 * @param pages the pages
	 * @param checkedOut the checked out
	 */
	public Book(Integer id, String title, String author, String publisher, String description, String imageUrl, Integer pages, Boolean checkedOut) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.imageUrl = imageUrl;
		this.pages = pages;
		this.checkedOut = checkedOut;
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
	 * Gets the pages.
	 *
	 * @return the pages
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * Sets the pages.
	 *
	 * @param pages the new pages
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the publisher.
	 *
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the publisher.
	 *
	 * @param publisher the new publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl the new image url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	

	/**
	 * Gets the checked out.
	 *
	 * @return the checked out
	 */
	public Boolean getCheckedOut() {
		return checkedOut;
	}

	/**
	 * Sets the checked out.
	 *
	 * @param checkedOut the new checked out
	 */
	public void setCheckedOut(Boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", description=" + description + ", imageUrl=" + imageUrl + ", checkedOut=" + checkedOut + ", pages="
				+ pages + "]";
	}

	

	

	

}
