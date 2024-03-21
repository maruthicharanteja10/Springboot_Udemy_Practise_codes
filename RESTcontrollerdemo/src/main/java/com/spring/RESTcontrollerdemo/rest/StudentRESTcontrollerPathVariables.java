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
public class StudentRESTcontrollerPathVariables {

	private List<Student> thestudent;

	// define @PostConstruct to load the student data..only once
	@PostConstruct
	public void loadData() {
		thestudent = new ArrayList<>();
		thestudent.add(new Student("tej", "charan"));
		thestudent.add(new Student("virat", "kohli"));
		thestudent.add(new Student("maruthi", "charan"));
	}

	// define endpoint for "/students" -return a list of students
	@GetMapping("/students")
	public List<Student> getstudents() {
		return thestudent;
	}

//-----------------------Exception handling -------------------------------
//	define endpoint for"/students/{studentid}"-return a student at index

	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable("studentId") int studentId) {
		// check the studentId again list size
		if (studentId >= thestudent.size() || (studentId < 0)) {
			throw new StudentNotFoundException("student is not found " + studentId);
		}
		return thestudent.get(studentId);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler // exception handler method
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		// create studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		// return ResponseEntity

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler ...to catch any exception(catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		// create studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		// return ResponseEntity

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
