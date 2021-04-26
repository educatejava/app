package com.educatejava.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.educatejava.app.repository.BookRepository;
import com.educatejava.app.repository.UserRepository;
import com.educatejava.app.vo.Book;
import com.educatejava.app.vo.User;

/**
 * The Class AppApplication.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.educatejava.app")
public class AppApplication implements CommandLineRunner {
	
	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;
	
	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	/**
	 * Run.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {

		bookRepository.deleteAll();

		// save a couple of customers
		bookRepository.save(new Book(1111, "Mule in Action", "David Dossot", "A", "Mule is a widely used open source enterprise service bus. It is standards based, provides easy integration with Spring and JBoss, and fully supports the enterprise messaging patterns collected by Hohpe and Woolf. You can readily customize Mule without writing a lot of new code.", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/dossot.jpg", 432));
		bookRepository.save(new Book(1112, "Java Foundation Classes", "Stephen", "A", "Java Foundation Classes: Swing Reference is the comprehensive guide to Swing 1.1 and Java 2's Swing package. Written by the programmers that maintain the Internet's Swing FAQ, this book is based on the much enhanced, most recent release of Swing.", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/drye.jpg", 1088));
		bookRepository.save(new Book(1113, "Java Network Programming, Second Edition", "Merlin Hughes", "B", "The first edition of Java Network Programming was acclaimed by readers as an outstanding networking reference. It provided complete details of the Java platform's support for networking and I/O with extensive API coverage and sophisticated examples. ", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/hughes.jpg", 860));
		bookRepository.save(new Book(1114, "Struts in Action, Second Edition", "Ted N. Husted", "B", "Struts solves the most common problems of web development. By basing your application on the Struts framework, you can reuse proven solutions and focus on what's unique to your own case. Struts is an open-source product distributed by the Apache Software Foundation.", "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/husted.jpg", 672));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findById(1112):");
		System.out.println("--------------------------------");
		System.out.println(bookRepository.findById(1112));

		System.out.println("Customers found with findByAuthor(\"Stephen\"):");
		System.out.println("--------------------------------");
		for (Book book : bookRepository.findByAuthor("Stephen")) {
			System.out.println(book);
		}

		userRepository.deleteAll();

		// save a couple of customers
		userRepository.save(new User("Alice", "1234"));
		userRepository.save(new User("Bob", "12345"));

		// fetch all customers
		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");
		for (User user : userRepository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

	}

}
