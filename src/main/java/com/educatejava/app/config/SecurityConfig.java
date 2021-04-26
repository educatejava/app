package com.educatejava.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.educatejava.app.service.AppUserDetailsService;

/**
 * The Class SecurityConfig.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	/** The Constant LOGIN_URL. */
	private static final String LOGIN_URL = "/login";
	
	/** The Constant LOGIN_FAILURE. */
	private static final String LOGIN_FAILURE = "/login?error=true";
	
	/** The Constant INDEX_URL. */
	private static final String INDEX_URL = "/index";

	/** The app user details service. */
	@Autowired
	private AppUserDetailsService appUserDetailsService;

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOGGER.debug("SecurityConfig.configure() Configuring HTTP Security.");
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage(LOGIN_URL)
				.loginProcessingUrl(LOGIN_URL).failureUrl(LOGIN_FAILURE).defaultSuccessUrl(INDEX_URL, true)
				.permitAll().and().logout().permitAll().logoutSuccessUrl(LOGIN_URL).invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");

	}

	/**
	 * Password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Configure.
	 *
	 * @param builder the builder
	 * @throws Exception the exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		LOGGER.debug("SecurityConfig.configure() Configuring User Authentication.");
		builder.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

}
