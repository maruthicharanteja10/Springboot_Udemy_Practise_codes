package com.example.BasicDemoConcepts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String resourcename;
	private String fieldname;
	private Object fieldValue;

	public ResourceNotFoundException(String resourcename, String fieldname, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourcename, fieldname, fieldValue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

}
