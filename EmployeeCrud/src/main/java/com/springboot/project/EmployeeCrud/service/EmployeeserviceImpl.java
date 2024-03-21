package com.springboot.project.EmployeeCrud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.EmployeeCrud.DAO.EmployeeDao;
import com.springboot.project.EmployeeCrud.entity.Employee;

import jakarta.transaction.Transactional;

//@Service
//public class EmployeeserviceImpl implements EmployeeService {
//
//	private EmployeeDao employeeDao;
//
//	@Autowired
//	public EmployeeserviceImpl(EmployeeDao theemployeeDao) {
//		employeeDao = theemployeeDao;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		return employeeDao.findall();
//	}
//
//	@Override
//	public Employee findById(int theId) {
//		return employeeDao.findById(theId);
//	}
//
//	@Transactional
//	@Override
//	public Employee save(Employee theEmployee) {
//		return employeeDao.save(theEmployee);
//	}
//
//	@Transactional
//	@Override
//	public void deleteById(int theid) {
//		employeeDao.deleteById(theid);
//	}
//
//}
