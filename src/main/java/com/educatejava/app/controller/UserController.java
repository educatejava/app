package com.educatejava.app.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class UserController.
 */
@Controller
public class UserController {
	
	//login, registration, logout
	
	/**
	 * Handle login.
	 *
	 * @return the string
	 * @throws MessagingException the messaging exception
	 */
	@RequestMapping(value = "/login")
    public String handleLogin() throws MessagingException {
        return "login";
    }
	
	
	

}
