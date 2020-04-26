package com.nagarro.travelportal.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmailService;
import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.model.Employee;
import com.nagarro.travelportal.model.LoginCredentials;
import org.json.JSONObject;

/**
 * The Class EmployeeLoginController.
 */
@RestController
public class EmployeeLoginController {

	private static Logger log = Logger.getLogger(EmployeeLoginController.class);

	@Autowired
	private EmployeeService empService;

	@Autowired
	private EmailService emailService;

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
			if (credentials.getPassword().equals(emp.getPassword())) {
				log.info("User trying to login is:" + emp);
				res.put("login", "success");
				return new ResponseEntity<String>(res.toString(), HttpStatus.OK);
			} else {
				log.fatal("Wrong Credentials.");
				res.put("login", "failed");
				return new ResponseEntity<String>(res.toString(), HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception e) {
			log.fatal("User with " + credentials.getUsername() + " doesnot exists");
			res.put("login", "failed");
			return new ResponseEntity<String>(res.toString(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Gets the credentials if User forgets his password.
	 *
	 * @param email the email
	 * @return the credentials
	 */
	@GetMapping("/{emailaddress}/forgotpassword")
	public ResponseEntity<String> getCredentials(@PathVariable(value = "emailaddress") String email) {

		Employee employee = empService.getEmployeeByUsername(email);
		StringBuffer text = new StringBuffer();
		text.append("Greetings for the day!").append("\n" + "\n" + "\n")
				.append("Login Credentials for your account are:").append("\n" + "\n")
				.append("Username: " + employee.getUsername()).append("\n")
				.append("Password: " + employee.getPassword()).append("\n" + "\n" + "\n").append("Regards!")
				.append("\n").append("Nagarro Travel Team");

		emailService.sendEmail(email, text.toString());
		log.info("Mail with username and password has been sent");
		return new ResponseEntity<String>("Mail has been sent to your registered email address",HttpStatus.OK);

	}
}
