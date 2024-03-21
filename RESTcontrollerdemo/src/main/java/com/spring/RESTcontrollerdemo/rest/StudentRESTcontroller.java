package com.spring.RESTcontrollerdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.RESTcontrollerdemo.entity.Student;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRESTcontroller {

	// define endpoint for "/students" -return a list of students
//	@GetMapping("/students")
//	public List<Student> getstudents() {
//		List<Student> thestudent = new ArrayList<>();
//		thestudent.add(new Student("tej", "charan"));
//		thestudent.add(new Student("virat", "kohli"));
//		thestudent.add(new Student("maruthi", "charan"));
//		return thestudent;
//	}
}
