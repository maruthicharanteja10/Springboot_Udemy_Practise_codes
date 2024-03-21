package com.example.BasicDemoConcepts.service;

import org.springframework.stereotype.Service;

import com.example.BasicDemoConcepts.entity.Employee;
import com.example.BasicDemoConcepts.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeRepository employeeRepository;

//here autowired is not required
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee addEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
