package com.spring.project.EmployeeCrudSimple.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.project.EmployeeCrudSimple.entity.Employee;

//@RepositoryRestResource(path = "members")
//Above annotation  is not used then we can default name is employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// instead of creating DAO,DAOimpl for every entity
	// we can use JpaRespository to decrease boiler plate code
}
