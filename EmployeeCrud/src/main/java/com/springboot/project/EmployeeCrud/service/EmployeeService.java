package com.springboot.project.EmployeeCrud.service;

import java.util.List;
import com.springboot.project.EmployeeCrud.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theid);
}
