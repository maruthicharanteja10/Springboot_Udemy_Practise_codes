package com.springboot.project.EmployeeCrud.DAO;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.project.EmployeeCrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	// define field for entity manager
	private EntityManager entitymanager;

	// set up a constructor injection
	@Autowired
	public EmployeeDaoImpl(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	@Override
	public List<Employee> findall() {
		// method-1
//		String query="select e from Employee e";
//		Query theQuery = entitymanager.createQuery(query);
		// method-2
		TypedQuery<Employee> theQuery = entitymanager.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Employee theEmployee = entitymanager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = entitymanager.merge(theEmployee);
		return dbEmployee;
	}

	@Override
	public void deleteById(int theid) {
		Employee Emp = entitymanager.find(Employee.class, theid);
		entitymanager.remove(Emp);
	}

}
