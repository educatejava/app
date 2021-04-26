package com.educatejava.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.educatejava.app.vo.User;

/**
 * The Interface UserRepository.
 */
@Component
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	public User findByUserName(String userName);

}
