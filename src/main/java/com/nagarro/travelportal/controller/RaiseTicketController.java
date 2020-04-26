package com.nagarro.travelportal.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.Service.TicketService;
import com.nagarro.travelportal.model.Employee;
import com.nagarro.travelportal.model.Ticket;

/**
 * The Class RaiseTicketController.
 */
@RestController
public class RaiseTicketController {

	/** The log. */
	private Logger log = Logger.getLogger(RaiseTicketController.class);

	/** The ticket service. */
	@Autowired
	private TicketService ticketService;

	/** The emp service. */
	@Autowired
	private EmployeeService empService;

	/**
	 * Raise ticket.
	 *
	 * @param user the user
	 * @param ticket the ticket
	 * @return the response entity
	 */
	@PostMapping("{user}/raise")
	public ResponseEntity<String> raiseTicket(
			@PathVariable(value = "user") String user,
			@Valid @RequestBody Ticket ticket) {
	
		Employee emp =empService.getEmployeeByUsername(user);
		
		
		if(emp == null) {
			log.error("USer with "+user+" not found.");
			return new ResponseEntity<String>("User not found with username: "+user,HttpStatus.EXPECTATION_FAILED);
		}
		//foreign key set.
		ticket.setEmployee(emp);
		
		if (ticketService.addOrUpdateTicket(ticket) != null) {
			log.info("Ticket to travel from " + ticket.getFrom() + " to " + ticket.getTravelCity()
					+ " has been raised. ");
			return new ResponseEntity<String>("Ticket Raised Succesfuly", HttpStatus.OK);
		}
		
		log.info("Ticket not raised ");
		return new ResponseEntity<String>("Ticket not Raised", HttpStatus.EXPECTATION_FAILED);
	}

}
