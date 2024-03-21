package com.springboot.EmployeeCrudSecurity.security;

import javax.sql.DataSource;



import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
	 * tej =
	 * User.builder().username("tej").password("{noop}tej123").roles("EMPLOYEE").
	 * build(); UserDetails charan =
	 * User.builder().username("charan").password("{noop}charan123").roles(
	 * "EMPLOYEE", "MANAGER") .build(); UserDetails maruthi =
	 * User.builder().username("maruthi").password("{noop}maruthi123")
	 * .roles("EMPLOYEE", "MANAGER", "ADMIN").build(); return new
	 * InMemoryUserDetailsManager(tej, charan, maruthi);
	 * 
	 * }
	 */

	// Add code for JDBC ......No more hardcode users

	@Bean
	public UserDetailsManager detailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		// define query to retrieve the user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
		// define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
//		return new JdbcUserDetailsManager(dataSource);
		return jdbcUserDetailsManager;

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/api/employees")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

		);
		// use http Basic authentication
		http.httpBasic(Customizer.withDefaults());
		// disable cross site request forgery(CSRF)
		// In general,not required for stateless REST API's that use POST,PUT,DELETE
		// and/or PATCH
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
