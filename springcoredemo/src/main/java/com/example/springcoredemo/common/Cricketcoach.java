package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // marks the class as spring bean
@Primary
public class Cricketcoach implements Coach {
	public Cricketcoach() {
		System.out.println("In constructor :" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "practise fast bowling for 15 minutes!!";
	}

}
