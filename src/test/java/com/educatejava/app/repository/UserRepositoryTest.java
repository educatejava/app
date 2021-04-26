package com.educatejava.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.educatejava.app.vo.User;

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository; 

	User hari, oliver, carter;

	@BeforeEach
	public void setUp() {

		userRepository.deleteAll();

		hari = userRepository.save(new User("Hari", "12345"));
		oliver = userRepository.save(new User("Oliver August", "123456"));
		carter = userRepository.save(new User("Carter", "12345678"));
	}

	@Test
	public void setsIdOnSave() {

		User dave = userRepository.save(new User("Hari", "258369"));

		assertThat(dave.getId()).isNotNull();
	}

	@Test
	public void findsByLastName() {

		User user = userRepository.findByUserName("Hari");

		assertThat(user).extracting("userName").isEqualTo("Hari");
	}

	@Test
	public void findsByExample() {

		User probe = new User("Carter", null);

		List<User> result = userRepository.findAll(Example.of(probe));

		assertThat(result).hasSize(1).extracting("userName").contains("Carter");
	}

}
