package com.example.BasicDemoConcepts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BasicDemoConcepts.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//does not need @Repository annotation
	//does not need @Transactional annotation
	//does not need @Autowired in employeeService impl for constructor injection
}
