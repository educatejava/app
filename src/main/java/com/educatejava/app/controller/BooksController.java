package com.educatejava.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * The Class BooksController.
 */
@Controller
public class BooksController {
	//add book, update book
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BooksController.class);
	
	/**
	 * Adds the book.
	 *
	 * @return the boolean
	 */
	public Boolean addBook() {
		LOGGER.debug("BooksController.addBook() Adding new Book.");
		return null;
	}
}
