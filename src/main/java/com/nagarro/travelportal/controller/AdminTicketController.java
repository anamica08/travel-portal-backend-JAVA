package com.nagarro.travelportal.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.EmployeeService;
import com.nagarro.travelportal.Service.TicketService;
import com.nagarro.travelportal.model.Employee;
import com.nagarro.travelportal.model.Ticket;



@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminTicketController {


	/** The log. */
private Logger log = Logger.getLogger(AdminTicketController.class);

	/** The ticket service. */
	@Autowired
	private TicketService ticketService;
	
	/** The emp service. */
	@Autowired
	private EmployeeService empService;

	/**
	 * Gets the all tickets.
	 *
	 * @return the all tickets
	 */
	@GetMapping("/ticket")
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTicket();
	}

	/**
	 * Update ticket.
	 *
	 * @param ticketToUpdate the ticket to update
	 * @return the response entity
	 */
	@PatchMapping("/ticket")
	//@RequestMapping(value = "/ticket/update", method = RequestMethod.PATCH, consumes = { "multipart/form-data" })
	public ResponseEntity<String> updateTicket( @Valid @RequestBody Ticket ticketToUpdate) {

		try {
			
			log.info(ticketService.getTicketById(ticketToUpdate.getTickedId())); //throws no such element exception.
			
			// obtain the employee who raised this ticket.
			Employee empObj = empService.getEmployeeByUsername(ticketService.ticketRaisedBy(ticketToUpdate.getTickedId()));
			ticketToUpdate.setEmployee(empObj);
			ticketService.addOrUpdateTicket(ticketToUpdate);
			
			return new ResponseEntity<String>("Admin Action on ticket is done succesfully.",HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			log.info("Ticket for id " + ticketToUpdate.getTickedId() + " is not found");
		}
		 return new ResponseEntity<String>("Ticket Update failed.",HttpStatus.NOT_FOUND);

	}

	
}
