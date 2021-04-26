package com.educatejava.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educatejava.app.repository.BookRepository;
import com.educatejava.app.vo.Book;

/**
 * Controller class for Application main flows.
 *
 */
@Controller
public class AppController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * Gets the library page.
	 *
	 * @param model the model
	 * @return the library page
	 */
	@RequestMapping(value = "/library")
	public String handleLibraryPage(Model model) {
		LOGGER.debug("AppController.handleLibraryPage() Access Library Page.");
		model.addAttribute("message", "Hello World!");
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books",books);
		return "library";
	}
	
	/**
	 * Gets the index page.
	 *
	 * @param model the model
	 * @param request the request
	 * @return the index page
	 */
	@RequestMapping(value = "/index")
	public String handleIndexPage(Model model, HttpServletRequest request) {
		LOGGER.debug("AppController.handleIndexPage() Access Index Page.");
		String userName = request.getUserPrincipal().getName();
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		auth.getPrincipal();*/
		model.addAttribute("message", "Hello "+userName+ "!");
		return "index";
	}

}
