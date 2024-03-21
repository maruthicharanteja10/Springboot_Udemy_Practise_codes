package com.spring.Mvc.EmployeeCrudThymleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.Mvc.EmployeeCrudThymleaf.Entity.Employee;
import com.spring.Mvc.EmployeeCrudThymleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeContoller {
	private EmployeeService employeeService;

	public EmployeeContoller(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model themodel) {
		List<Employee> theEmployees = employeeService.findAll();
		themodel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}

	@GetMapping("/showFormToAdd")
	public String showFormToAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		// use to prevent duplicate submissions
		return "redirect:/employees/list";

	}

	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";

	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		// use to prevent duplicate submissions
		return "redirect:/employees/list";

	}

}
