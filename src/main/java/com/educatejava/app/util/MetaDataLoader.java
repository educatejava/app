package com.educatejava.app.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.educatejava.app.repository.BookRepository;
import com.educatejava.app.repository.UserRepository;
import com.educatejava.app.vo.Book;
import com.educatejava.app.vo.User;

/**
 * The Class MetaDataLoader.
 */
@Component
public class MetaDataLoader {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MetaDataLoader.class);
	
	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;
	
	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Load meta data.
	 */
	private void loadMetaData() {
		bookRepository.deleteAll();

		// save a couple of books
		bookRepository.save(new Book(1111, "Mule in Action", "David Dossot", "O'Reilly Media", "Mule is a widely used open source enterprise service bus. It is standards based, provides easy integration with Spring and JBoss", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/dossot.jpg", 432,true));
		bookRepository.save(new Book(1112, "Java Foundation Classes", "Stephen", "O'Reilly Media", "Java Foundation Classes: Swing Reference is the comprehensive guide to Swing 1.1 and Java 2's Swing package.", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/drye.jpg", 1088,false));
		bookRepository.save(new Book(1113, "Java Network Programming, Second Edition", "Merlin Hughes", "HarperCollins", "The first edition of Java Network Programming was acclaimed by readers as an outstanding networking reference. ", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/hughes.jpg", 860,true));
		bookRepository.save(new Book(1114, "Struts in Action, Second Edition", "Ted N. Husted", "Hachette Livre", "Struts solves the most common problems of web development. By basing your application on the Struts framework.", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/husted.jpg", 672,false));
		bookRepository.save(new Book(1115, "Camel in Action", "Ted", "Livre", "Camel in Action is for developers working with integration of any kind. This highly practical book introduces Camel and shows examples of how to use it with the 45+ supported enterprise integration patterns.", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ibsen.jpg", 652,false));

		// fetch all books
		LOGGER.debug("Customers found with findAll():");
		LOGGER.debug("-------------------------------");
		for (Book book : bookRepository.findAll()) {
			LOGGER.debug("Book: {}", book);
		}
		LOGGER.debug("");

		// fetch an individual books
		LOGGER.debug("Customer found with findById(1112):");
		LOGGER.debug("--------------------------------");
		LOGGER.debug("Find Book ById: {}", bookRepository.findById(1112));

		LOGGER.debug("Customers found with findByAuthor(\"Stephen\"):");
		LOGGER.debug("--------------------------------");
		for (Book book : bookRepository.findByAuthor("Stephen")) {
			LOGGER.debug("Book: {}",book);
		}

		userRepository.deleteAll();
		
		List<Integer> bookIDList1 = new ArrayList<>();
		bookIDList1.add(1111);bookIDList1.add(1114);bookIDList1.add(1115);
		List<Integer> bookIDList2 = new ArrayList<>();
		bookIDList2.add(1112);bookIDList2.add(1113);
		// save a couple of customers
		userRepository.save(new User("Hari", passwordEncoder.encode("1234"), bookRepository.findByIdIn(bookIDList1)));
		userRepository.save(new User("Venkat", passwordEncoder.encode("12345"), bookRepository.findByIdIn(bookIDList2)));

		// fetch all customers
		LOGGER.debug("User found with findAll():");
		LOGGER.debug("-------------------------------");
		for (User user : userRepository.findAll()) {
			LOGGER.debug("User: {}",user);
		}
		LOGGER.debug("");
	}
	
	/**
	 * Inits the.
	 *
	 * @throws Exception the exception
	 */
	@PostConstruct
	public void init() throws Exception {
		loadMetaData();
	}

}
