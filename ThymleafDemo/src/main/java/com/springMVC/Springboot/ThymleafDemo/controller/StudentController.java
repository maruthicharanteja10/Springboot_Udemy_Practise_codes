package com.springMVC.Springboot.ThymleafDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springMVC.Springboot.ThymleafDemo.model.Student;

@Controller
public class StudentController {

	@Value("${countries}")
	private List<String> countries;

	@Value("${languages}")
	private List<String> languages;

	@Value("${systems}")
	private List<String> systems;

	@GetMapping("/showStudentForm")
	public String ShowFrom(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		// add the list of countries to the model
		theModel.addAttribute("countries", countries);
		theModel.addAttribute("languages", languages);
		theModel.addAttribute("systems", systems);
		return "Student-form";
	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("the student : " + theStudent.getFirstName() + " " + theStudent.getLastName());
		System.out.println("Selected country :" + theStudent.getCountry());
		System.out.println("Favourite Lanaguage : " + theStudent.getFavoriteLanguage());
		System.out.println("Favourite Operating system" + theStudent.getFavoriteSystems());
		return "student-confirmation";
	}
}
