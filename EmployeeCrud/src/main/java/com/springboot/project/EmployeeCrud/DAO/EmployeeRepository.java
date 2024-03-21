package com.springboot.project.EmployeeCrud.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.EmployeeCrud.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// instead of creating DAO,DAOimpl for every entity
	// we can use JpaRespository to decrease boiler plate code
}
