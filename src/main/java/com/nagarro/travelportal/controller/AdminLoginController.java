package com.nagarro.travelportal.controller;

import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.model.LoginCredentials;

@RestController
public class AdminLoginController {
	
	private static Logger log = Logger.getLogger(EmployeeLoginController.class);
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> getAdmin(@RequestBody LoginCredentials credentials) {

		JSONObject res = new JSONObject();
		res.put("username", credentials.getUsername());
		if(credentials.getUsername().equalsIgnoreCase("admin") && credentials.getPassword().equals("1234")) {
			log.info("User trying to login is:" + credentials.getUsername());
			res.put("login", "success");
			return new ResponseEntity<String>(res.toString(), HttpStatus.FOUND);
		}else {
			log.fatal("User with " + credentials.getUsername() + " doesnot exists");
			res.put("login", "failed");
			return new ResponseEntity<String>(res.toString(), HttpStatus.NOT_FOUND);
		}	
	}
}
