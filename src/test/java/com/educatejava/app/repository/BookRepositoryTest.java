package com.educatejava.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educatejava.app.vo.Book;

@SpringBootTest
class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository; 

	Book springAction, learnJava;

	@BeforeEach
	public void setUp() {

		bookRepository.deleteAll();

		springAction = bookRepository.save(new Book(123,"Spring In Action", "Robert", "Manning", "description", "https://www.test.com/image.jpg",200,true));
		learnJava = bookRepository.save(new Book(124,"Learn Java", "Venu", "OReilly", "description", "https://www.test.com/image.jpg",250,false));
	}

	@Test
	public void findsByTitle() {

		List<Book> springAction = bookRepository.findByTitle("Spring In Action");

		assertThat(springAction.get(0)).extracting("author").isEqualTo("Robert");
	}
	
	@Test
	public void findsByAuthor() {

		List<Book> springAction = bookRepository.findByAuthor("Venu");

		assertThat(springAction.get(0)).extracting("publisher").isEqualTo("OReilly");
	}

}
