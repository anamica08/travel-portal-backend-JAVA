//package com.nagarro.travelportal.Service;
//
//import org.jboss.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.nagarro.travelportal.model.Employee;
//
//
//@Service
//public class RegisterNewUserService {
//	/** The log. */
//	private Logger log = Logger.getLogger(RegisterNewUserService.class);
//
//	/** The emp service. */
//	@Autowired
//	private EmployeeService empService;
//
//	/** The email service. */
//	@Autowired
//	private EmailService emailService;
//	
//	/** The bcrypt encoder. */
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//	
//	
//public Employee createUserAsEmployee(Employee employee) {
//		
//		
//		
//		//check if receieved employee already in system then he cannot register.
//		if(empService.userAlreadyExist(employee)) {
//			log.info("User " + employee.getUsername() + " is already registered");
//			emailService.welcomeMail(employee.getEmail());
//			return null;
//			
//		}
//		
//		Employee employeeToAdd = empService.addEmployee(employee) ;
//		
////		if (employeeToAdd== null) {
////			log.info("User" + employee.getUsername() + " is not registered");
////			return new ResponseEntity<String>("Registration Failed", HttpStatus.EXPECTATION_FAILED);
////		}
//		
//		
//		log.info("User " + employee.getUsername() + " is succesfully registered");
//		
//		// send a welcomeMail.
//		String password = emailService.welcomeMail(employeeToAdd.getEmail());
//		
//		
//		//set password for new user.
//		employeeToAdd.setPassword(bcryptEncoder.encode(password));
//		//empService.addEmployee(employeeToAdd);
//		
//		return empService.addEmployee(employeeToAdd);
//		
//	}	
//}
