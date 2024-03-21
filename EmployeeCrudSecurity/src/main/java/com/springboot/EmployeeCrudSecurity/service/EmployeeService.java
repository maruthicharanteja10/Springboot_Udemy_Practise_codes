package com.springboot.EmployeeCrudSecurity.service;

import java.util.List;

import com.springboot.EmployeeCrudSecurity.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theid);
}
