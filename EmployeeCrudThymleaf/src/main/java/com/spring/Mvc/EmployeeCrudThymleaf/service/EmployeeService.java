package com.spring.Mvc.EmployeeCrudThymleaf.service;

import java.util.List;

import com.spring.Mvc.EmployeeCrudThymleaf.Entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theid);
}
