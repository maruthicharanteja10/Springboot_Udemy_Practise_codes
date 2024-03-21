package com.example.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {
	public BaseballCoach() {
		System.out.println("In constructor :" + getClass().getSimpleName());
	}

	// define our init method
//	@PostConstruct
//	public void doMyStartupstuff() {
//		System.out.println("In doing my startupstuff : " + getClass().getSimpleName());
//	}

	// define our destroy method

//	@PreDestroy
//	public void doMycleanupstuff() {
//		System.out.println("In doing my cleanupstuff : " + getClass().getSimpleName());
//	}
//
	@Override
	public String getDailyWorkout() {
		return "spend 30min in battng practise";
	}

}
