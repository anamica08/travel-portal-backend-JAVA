package com.nagarro.travelportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> list(){
		return empService.getAllEmployee();
	}
}
