package com.nagarro.travelportal.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelportal.dao.TicketDao;
import com.nagarro.travelportal.model.Ticket;


@Service
public class TicketService {
	
	@Autowired
	private TicketDao ticketdao;
	/**
	 * Adds the ticket.
	 *
	 * @param newTicket the new ticket
	 * @return the ticket
	 */
	public Ticket addOrUpdateTicket(Ticket ticket) {
		/**save method automatically updates the entity object if it already exists.*/
		return ticketdao.save(ticket);
	}
	
//	/**
//	 * Edits the ticket.
//	 *
//	 * @param ticket the ticket
//	 * @return the ticket
//	 */
//	public Ticket editTicket(Ticket ticket) {
//		return null;
//	}
	
	/**
	 * Gets the all ticket.
	 *
	 * @return the all ticket
	 */
	public List<Ticket> getAllTicket() {
		return ticketdao.findAll();
	}
	
	/**
	 * Gets the by username.
	 *
	 * @param username the username
	 * @return the by username
	 */
	public List<Ticket> getByUsername(String username)throws NoSuchElementException {
		return ticketdao.findByUsername(username);
		
	}
	
	/**
	 * Gets the ticket by id.
	 *
	 * @param id the id
	 * @return the ticket by id
	 */
	public Ticket getTicketById(int id)throws NoSuchElementException {
		return ticketdao.findById(id).get();
	}
	
	
	/**
	 * Ticket raised by.
	 *
	 * @param ticketId the ticket id
	 * @return the string
	 */
	public String ticketRaisedBy(Integer ticketId) {
		return ticketdao.ticketRaiseBy(ticketId);
	}
	
	
}
