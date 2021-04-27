package com.educatejava.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.educatejava.app.vo.Book;
import com.educatejava.app.vo.User;

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository; 

	User hari, oliver, carter;
	Book book1, book2;
	List<Book> books1, books2, books3;

	@BeforeEach
	public void setUp() {

		userRepository.deleteAll();
		book1 = new Book(123,"Spring In Action", "Robert", "Manning", "description", "https://www.test.com/image.jpg",200,true);
		book2 = new Book(124,"Learn Java", "Venu", "OReilly", "description", "https://www.test.com/image.jpg",250,false);
		books1 = new ArrayList<>();
		books1.add(book1);
		books2 = new ArrayList<>();
		books1.add(book1);books1.add(book2);
		books3 = new ArrayList<>();
		books1.add(book2);
		
		hari = userRepository.save(new User("Hari", "12345",books1));
		oliver = userRepository.save(new User("Oliver August", "123456", books2));
		carter = userRepository.save(new User("Carter", "12345678", books3));
	}

	@Test
	public void setsIdOnSave() {

		User dave = userRepository.save(new User("Hari", "258369", books1));

		assertThat(dave.getId()).isNotNull();
	}

	@Test
	public void findsByLastName() {

		User user = userRepository.findByUserName("Hari");

		assertThat(user).extracting("userName").isEqualTo("Hari");
	}

	@Test
	public void findsByExample() {

		User probe = new User("Carter", null, books3);

		List<User> result = userRepository.findAll(Example.of(probe));

		assertThat(result).hasSize(1).extracting("userName").contains("Carter");
	}

}
