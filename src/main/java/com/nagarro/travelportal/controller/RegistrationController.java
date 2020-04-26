package com.nagarro.travelportal.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.model.Employee;


/**
 * The Class RegistrationController.
 */
@RestController
public class RegistrationController {

	
	/** The log. */
	private Logger log = Logger.getLogger(RegistrationController.class);
	
	/** The emp service. */
	@Autowired
	private EmployeeService empService;
	
	/**
	 * Creates the user as employee.
	 *
	 * @param employee the employee
	 * @return the response entity
	 */
	@PostMapping("/register")
	public ResponseEntity<String> createUserAsEmployee(@Valid @RequestBody Employee employee){
		if(empService.addEmployee(employee) != null) {
			log.info("User "+ employee.getUsername()+" is succesfully registered");
			return new ResponseEntity<String>("Employee registered Successfully", HttpStatus.OK);
		}
		log.info("User"+ employee.getUsername()+" is not registered");
		return new ResponseEntity<String>("Employee not registered", HttpStatus.EXPECTATION_FAILED);
	}
}
