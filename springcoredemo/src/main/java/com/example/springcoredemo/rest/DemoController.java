package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach myCoach;
//	private Coach anotherCoach;

	// define a constructor for dependency injection
	@Autowired
	// tells spring to inject a dependency
	// if you have one constructor @autowired on constructor is optional
	public DemoController(@Qualifier("teja") Coach theCoach) {
//			@Qualifier("baseballCoach") Coach theAnotherCoach) {
		System.out.println("In constructor :" + getClass().getSimpleName());
		myCoach = theCoach;
//		anotherCoach = theAnotherCoach;
	}

	// define a setter injection for dependency injection
//	@Autowired
//	public void setMyCoach(Coach theCoach) {
//		myCoach = theCoach;
//	}
//	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
//
//	@GetMapping("/check")
//	public String check() {
//		return "Comparing mycoach with anothercoach is, " + (myCoach == anotherCoach);
// check to see if it is same bean (True or False depending on the bean scope)
	// singleton : true and prototype : false
//	}
}
