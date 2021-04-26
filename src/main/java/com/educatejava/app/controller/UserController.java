package com.educatejava.app.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class UserController.
 */
@Controller
public class UserController {
	
	/** The Constant LOGGER. */
	//login, registration, logout
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Handle login.
	 *
	 * @return the string
	 * @throws MessagingException the messaging exception
	 */
	@RequestMapping(value = "/login")
    public String handleLogin() throws MessagingException {
		LOGGER.debug("UserController.handleLogin() Access login page.");
        return "login";
    }
	
	/**
	 * Handle registration.
	 *
	 * @return the string
	 * @throws MessagingException the messaging exception
	 */
	@RequestMapping(value = "/register")
    public String handleRegistration() throws MessagingException {
		LOGGER.debug("UserController.handleLogin() Access Registration page.");
        return "login";
    }
	
	
	

}
