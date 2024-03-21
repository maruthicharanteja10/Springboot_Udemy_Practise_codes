package com.springBoot.Mvc.Entity;

import com.springBoot.Mvc.Validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	private String firstname;
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastname = "";

	@NotNull(message = "is Required")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Max(value = 10, message = "must be lessthan or equal to 10")
	private Integer freepasses;
//	private int freepasses;

	@Pattern(regexp = "^[a-z A-Z 0-9]{3,5}", message = "must be between 3-5chars/digits")
	@NotNull(message = "is Required")
	private String postalCode;
	
	@CourseCode(value = "10" ,message = "must starts with 10")
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getFreepasses() {
		return freepasses;
	}

	public void setFreepasses(Integer freepasses) {
		this.freepasses = freepasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
