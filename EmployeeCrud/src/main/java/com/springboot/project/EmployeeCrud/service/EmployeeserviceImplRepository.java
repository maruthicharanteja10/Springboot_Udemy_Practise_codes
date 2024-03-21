package com.springboot.project.EmployeeCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.EmployeeCrud.DAO.EmployeeRepository;
import com.springboot.project.EmployeeCrud.entity.Employee;


@Service
public class EmployeeserviceImplRepository implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeserviceImplRepository(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		// optional is a different pattern instead of having to check for nulls
		// (feature introduced in java8)
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not found employee id is :" + theId);
		}
		return theEmployee;
	}

//	@Transactional//remove transactional jpaRepository provides this functionality
	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

//	@Transactional
	@Override
	public void deleteById(int theid) {
		employeeRepository.deleteById(theid);
	}

}
