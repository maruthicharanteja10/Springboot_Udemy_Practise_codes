package com.springMVC.Springboot.ThymleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	// to show initial HTML form
//	@RequestMapping("/showform")
//	public String showform() {
//		return "helloworld-form";
//	}
	@GetMapping("/showform")
	public String showform() {
		return "helloworld-form";
	}

//	@PostMapping
//	public String showform() {
//		return "helloworld-form";
//	}

	// to process HTML form
	@RequestMapping("/processform")
	public String processform() {
		return "helloworld-output";
	}

	// need a controller method to read from data and
	// add data to the model
	@RequestMapping("/processformVersionTwo")
	public String letsDo(HttpServletRequest request, Model model) {
		// read the request from the HTMl form
		String theName = request.getParameter("studentName");
		// convert the data to all caps
		theName = theName.toUpperCase();
		// create the message
		String result = "Yo!" + theName;
		// add message to the model
		model.addAttribute("message", result);
		return "helloworld-output";
	}

	@PostMapping("/processformVersionThree")
	public String letsDo(@RequestParam("studentName") String theName, Model model) {
		theName = theName.toUpperCase();
		// create the message
		String result = "Heyy my Friend! " + theName;
		// add message to the model
		model.addAttribute("message", result);
		return "helloworld-output";
	}
}
