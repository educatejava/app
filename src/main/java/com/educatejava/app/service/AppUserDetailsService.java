package com.educatejava.app.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.educatejava.app.repository.UserRepository;
import com.educatejava.app.vo.User;

/**
 * The Class AppUserDetailsService.
 */
@Component
public class AppUserDetailsService implements UserDetailsService{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		LOGGER.debug("AppUserDetailsService.UserDetails() Loggedin User Is: {}", username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		LOGGER.debug("AppUserDetailsService.UserDetails() Authorizing User: {}", username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authorities);
	}

}
