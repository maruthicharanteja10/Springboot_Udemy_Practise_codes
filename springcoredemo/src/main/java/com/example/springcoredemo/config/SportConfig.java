package com.example.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springcoredemo.common.Coach;
import com.example.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	@Bean("teja")
	// bean id defaults to the method name
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
