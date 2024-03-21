package com.springBoot.Mvc.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstriantValidator implements ConstraintValidator<CourseCode, String> {

	private String courseprefix;

	@Override
	public void initialize(CourseCode theCoursecode) {
		courseprefix = theCoursecode.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean result ; 
		if(value!=null) {
			result=value.startsWith(courseprefix);
		}
		else {
			result=true;
		}
		return result;
	}

}
