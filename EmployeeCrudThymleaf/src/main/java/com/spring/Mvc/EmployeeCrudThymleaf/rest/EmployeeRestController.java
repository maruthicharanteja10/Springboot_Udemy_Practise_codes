package com.spring.Mvc.EmployeeCrudThymleaf.rest;

import java.util.List;


import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Mvc.EmployeeCrudThymleaf.Entity.Employee;
import com.spring.Mvc.EmployeeCrudThymleaf.service.EmployeeService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//	private EmployeeDao employeeDao;
//
//	// quick and dirty: inject employee dao(using constructor injection)
//	public EmployeeRestController(EmployeeDao TheEmployeeDao) {
//		this.employeeDao = TheEmployeeDao;
//	}
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService TheemployeeService) {
		employeeService = TheemployeeService;
	}

	// Expose "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findall() {
		return employeeService.findAll();
	}

//Expose "/employees/{employeeid}" to return employee details with id
	@GetMapping("/employees/{employeeid}")
	public Employee getemployee(@PathVariable int employeeid) {
		Employee theEmployee = employeeService.findById(employeeid);

		if (theEmployee == null) {
			throw new RuntimeException("Employee is not found with Id : " + employeeid);
		}
		return theEmployee;
	}

	// add mapping for POST /employees -add a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		// also just in case they pass an id in JSON ...set id to 0
		// this is to force a save of new item....instead of update
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;

	}

	@DeleteMapping("/employees/{empId}")
	public String DeleteEmployee(@PathVariable int empId) {
		Employee tempEmployee = employeeService.findById(empId);
		if (tempEmployee == null) {
			throw new RuntimeException("Employee not found with id" + empId);
		}
		employeeService.deleteById(empId);
		return "Deleted employee with id : " + empId;

	}
}
