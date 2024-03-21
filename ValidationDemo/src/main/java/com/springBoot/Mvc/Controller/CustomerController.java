package com.springBoot.Mvc.Controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springBoot.Mvc.Entity.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	// add an InitBinder....to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/")
	public String showform(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";

	}

	@PostMapping("/processform")
	public String processform(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {
		System.out.println("Lastname : " + theCustomer.getLastname());
		System.out.println("Binding results : "+bindingResult.toString());
		
		if (bindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}
}
