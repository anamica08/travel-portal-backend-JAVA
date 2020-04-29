package com.nagarro.travelportal.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmailService;
import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.model.Employee;

/**
 * The Class RegistrationController.
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RegistrationController {
	

	/** The log. */
	private Logger log = Logger.getLogger(RegistrationController.class);

	/** The emp service. */
	@Autowired
	private EmployeeService empService;

	/** The email service. */
	@Autowired
	private EmailService emailService;

	
	
	
	

	/**
	 * Creates the user as employee.
	 *
	 * @param employee the employee
	 * @return the response entity
	 */
	@PostMapping("/register")
	public ResponseEntity<String> createUserAsEmployee(@Valid @RequestBody Employee employee) {
		
		
		
		//check if receieved employee already in system then he cannot register.
		if(empService.userAlreadyExist(employee)) {
			log.info("User " + employee.getUsername() + " is already registered");
			emailService.welcomeMail(employee.getEmail());
			return new ResponseEntity<String>("Registration Failed", HttpStatus.EXPECTATION_FAILED);
		}
		
		Employee employeeToAdd = empService.addEmployee(employee) ;
		
//		if (employeeToAdd== null) {
//			log.info("User" + employee.getUsername() + " is not registered");
//			return new ResponseEntity<String>("Registration Failed", HttpStatus.EXPECTATION_FAILED);
//		}
		
		
		log.info("User " + employee.getUsername() + " is succesfully registered");
		
		// send a welcomeMail.
		String password = emailService.welcomeMail(employeeToAdd.getEmail());
		
		
		//set password for new user.
		employeeToAdd.setPassword(password);
		empService.addEmployee(employeeToAdd);
		
		return new ResponseEntity<String>("Employee registered Successfully", HttpStatus.OK);
		
	}	
}
