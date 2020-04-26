package com.nagarro.travelportal.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelportal.Service.TicketService;
import com.nagarro.travelportal.model.Ticket;

@RestController
public class RaiseTicketController {

	private Logger log = Logger.getLogger(RaiseTicketController.class);

	@Autowired
	private TicketService ticketService;

	@PostMapping("/raise")
	public ResponseEntity<String> raiseTicket(@Valid @RequestBody Ticket ticket) {
		if (ticketService.addOrUpdateTicket(ticket) != null) {
			log.info("Ticket to travel from " + ticket.getFrom() + " to " + ticket.getTravelCity()
					+ " has been raised. ");
			return new ResponseEntity<String>("Ticket Raised Succesfuly", HttpStatus.OK);
		}
		log.info("Ticket not raised ");
		return new ResponseEntity<String>("Ticket not Raised", HttpStatus.EXPECTATION_FAILED);
	}

}
