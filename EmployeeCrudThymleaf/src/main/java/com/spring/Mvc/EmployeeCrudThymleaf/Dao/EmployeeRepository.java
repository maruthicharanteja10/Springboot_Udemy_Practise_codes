package com.spring.Mvc.EmployeeCrudThymleaf.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Mvc.EmployeeCrudThymleaf.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// instead of creating DAO,DAOimpl for every entity
	// we can use JpaRespository to decrease boiler plate code
	//add a method to sort by last name
	public List<Employee> findAllByOrderByLastnameAsc();
	//spring data JPA magic...!
}
