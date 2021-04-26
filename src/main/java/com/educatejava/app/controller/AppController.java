package com.educatejava.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public String getLibraryPage(Model model) {
		model.addAttribute("message", "Hello World!");
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books",books);
		return "library";
	}
	
	/**
	 * Gets the index page.
	 *
	 * @param model the model
	 * @return the index page
	 */
	@RequestMapping(value = "/index")
	public String getIndexPage(Model model, HttpServletRequest request) {
		String userName = request.getUserPrincipal().getName();
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		auth.getPrincipal();*/
		model.addAttribute("message", "Hello "+userName+ "!");
		return "index";
	}

}
