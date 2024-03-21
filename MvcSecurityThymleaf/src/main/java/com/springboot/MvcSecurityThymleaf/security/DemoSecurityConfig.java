package com.springboot.MvcSecurityThymleaf.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails tej = User.builder().username("tej").password("{noop}tej123").roles("EMPLOYEE").build();
//		UserDetails charan = User.builder().username("charan").password("{noop}tej123").roles("EMPLOYEE", "MANAGER")
//				.build();
//		UserDetails maruthi = User.builder().username("maruthi").password("{noop}tej123")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//		return new InMemoryUserDetailsManager(tej, charan, maruthi);
//
//	}
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager theUserDetailmanager=new JdbcUserDetailsManager(dataSource);
		// define query to retrieve the user by username
		theUserDetailmanager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
		// define query to retrieve the authorities/roles by username
		theUserDetailmanager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
//				return new JdbcUserDetailsManager(dataSource);
		return theUserDetailmanager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("EMPLOYEE")
				.requestMatchers("/leaders/**").hasRole("MANAGER").requestMatchers("/systems/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
						.permitAll())
				.logout(logout -> logout.permitAll())
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

		return http.build();

	}

}
