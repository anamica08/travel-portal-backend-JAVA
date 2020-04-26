package com.nagarro.travelportal.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.model.Employee;
import com.nagarro.travelportal.model.LoginCredentials;
import org.json.JSONObject;

@RestController
public class EmployeeLoginController {
	
	private static Logger log = Logger.getLogger(EmployeeLoginController.class);
	
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> list() {
		return empService.getAllEmployee();
	}

	/**
	 * Gets the employee.
	 *
	 * @param credentials the credentials
	 * @return the employee
	 */
	@PostMapping("/login")
	public ResponseEntity<String> getEmployee(@RequestBody LoginCredentials credentials) {

		JSONObject res = new JSONObject();
		res.put("username", credentials.getUsername());

		try {
			Employee emp = empService.getEmployeeByUsername(credentials.getUsername());
			log.info("User trying to login is:" + emp);
			res.put("login", "success");
			return new ResponseEntity<String>(res.toString(), HttpStatus.FOUND);
		} catch (Exception e) {
			log.fatal("User with " + credentials.getUsername() + " doesnot exists");
			res.put("login", "failed");
			return new ResponseEntity<String>(res.toString(), HttpStatus.NOT_FOUND);
		}

	}
}
