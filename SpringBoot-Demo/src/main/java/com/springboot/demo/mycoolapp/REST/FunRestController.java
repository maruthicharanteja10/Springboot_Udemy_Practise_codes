package com.springboot.demo.mycoolapp.REST;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController { // setup REST controller

	// Inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;

	// expose new endpoint for "teaminfo"
	@GetMapping("/teaminfo")
	public String getteaminfo() {
		return "coachName: " + coachName + " , teamName: " + teamName;
	}

	// Expose "/" that returns "Hello World"

	@GetMapping("/") // Handle HTTP Get RequestsF
	public String sayHello() {
		return "Hello World";
	}

	// Expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 42k";
	}

	// Expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyfortune() {
		return "Byeeeeeeee";
	}
}
