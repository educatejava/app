package com.educatejava.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
//@EnableConfigurationProperties
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

	/** The Constant LOGIN_URL. */
	private final static String LOGIN_URL = "/login";

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

		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage(LOGIN_URL)
				.loginProcessingUrl(LOGIN_URL).failureUrl("/login?error=true").defaultSuccessUrl("/index", true)
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
		builder.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

}
