package com.springboot.project.EmployeeCrud.DAO;

import java.util.List;
import com.springboot.project.EmployeeCrud.entity.Employee;

public interface EmployeeDao {
	List<Employee> findall();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theid);
}
