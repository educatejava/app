package com.educatejava.app.controller;

import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class AppErrorController.
 */
@Controller
public class AppErrorController implements ErrorController{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppErrorController.class);
	
	/**
	 * Handle error.
	 *
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    request.getSession().invalidate();
	    LOGGER.debug("AppErrorController.handleError() Error while accessing page.");
	    if (Objects.nonNull(status)) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	LOGGER.debug("AppErrorController.handleError() Page Not Found Error.");
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	LOGGER.debug("AppErrorController.handleError() Internal Server Error.");
	        }
	    }
	    return "error";
	}

	/**
	 * Gets the error path.
	 *
	 * @return the error path
	 */
	@Override
	public String getErrorPath() {
		
		return null;
	}

}
