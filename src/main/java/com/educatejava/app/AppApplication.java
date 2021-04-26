package com.educatejava.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class AppApplication.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.educatejava.app")
public class AppApplication {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppApplication.class);


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOGGER.debug("App Main Method");
		SpringApplication.run(AppApplication.class, args);
	}
	

}
