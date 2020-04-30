package com.nagarro.travelportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
//	@PatchMapping("/ticket")
//	//@RequestMapping(value = "/ticket/update", method = RequestMethod.PATCH, consumes = { "multipart/form-data" })
//	public ResponseEntity<String> updateTicket( @Valid @RequestBody Ticket ticketToUpdate) {
//
//		try {
//			
//			ticketService.getTicketById(ticketToUpdate.getTickedId()); //throws no such element exception.
//			
//			// obtain the employee who raised this ticket.
//			Employee empObj = empService.getEmployeeByUsername(ticketService.ticketRaisedBy(ticketToUpdate.getTickedId()));
//			ticketToUpdate.setEmployee(empObj);
//			ticketService.addOrUpdateTicket(ticketToUpdate);
//			
//			return new ResponseEntity<String>("Admin Action on ticket is done succesfully.",HttpStatus.OK);
//			
//		} catch (NoSuchElementException e) {
//			log.info("Ticket for id " + ticketToUpdate.getTickedId() + " is not found");
//		}
//		 return new ResponseEntity<String>("Ticket Update failed.",HttpStatus.NOT_FOUND);
//
//	}
	@PostMapping(value = "/admin/ticket/update", consumes = { "multipart/form-data" }

			)
			public ResponseEntity<String> updateTicket(@Valid @RequestPart("ticket") Ticket ticketToUpdate,
					@RequestPart(required = false) MultipartFile file) {
				String fileDownloadUri = null;
				
				try {
					ticketService.getTicketById(ticketToUpdate.getTickedId()); // throws no such element exception.
					// obtain the employee who raised this ticket.
					Employee empObj = empService
							.getEmployeeByUsername(ticketService.ticketRaisedBy(ticketToUpdate.getTickedId()));
					
				
					String id = Integer.toString(ticketToUpdate.getTickedId());
					
					if (file != null) {
						fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(id)
								.toUriString();
						log.info("DownloadLink for the added file: " +fileDownloadUri);
						
						//add file realted information
						ticketToUpdate.setDownloadLink(fileDownloadUri);
						ticketToUpdate.setFiles(file.getBytes());
						
					}
					ticketToUpdate.setEmployee(empObj);
					ticketService.addOrUpdateTicket(ticketToUpdate);

					return new ResponseEntity<String>(fileDownloadUri, HttpStatus.OK);

				} catch (NoSuchElementException | IOException e) {
					log.info("Ticket for id " + ticketToUpdate.getTickedId() + " is not found");
				}
				return new ResponseEntity<String>("Ticket Update failed.", HttpStatus.NOT_FOUND);

			}

	
}
