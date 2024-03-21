package com.springboot.EmployeeCrudSecurity.DAo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.EmployeeCrudSecurity.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// instead of creating DAO,DAOimpl for every entity
	// we can use JpaRespository to decrease boiler plate code
}
