package com.nagarro.travelportal.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nagarro.travelportal.dao.TicketDao;
import com.nagarro.travelportal.model.Ticket;

/**
 * The Class TicketService.
 */
@Service
public class TicketService {

	/** The ticketdao. */
	@Autowired
	private TicketDao ticketdao;

	/**
	 * Adds the ticket.
	 *
	 * @param ticket the ticket
	 * @return the ticket
	 */
	public Ticket addOrUpdateTicket(Ticket ticket) {
		/** save method automatically updates the entity object if it already exists. */
		return ticketdao.save(ticket);
	}

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
	 * @throws NoSuchElementException the no such element exception
	 */
	public List<Ticket> getByUsername(String username) throws NoSuchElementException {
		return ticketdao.findByUsername(username);
		// edit karo
	}

	/**
	 * Gets the ticket by id.
	 *
	 * @param id the id
	 * @return the ticket by id
	 * @throws NoSuchElementException the no such element exception
	 */
	public Ticket getTicketById(int id) throws NoSuchElementException {
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

	/**
	 * Process ticket request used by Admin.
	 *
	 * @param ticket the ticket
	 * @param file   the file
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public JSONObject processTicketRequest(Ticket ticket, MultipartFile file) throws IOException {
		Ticket toUpdate = getTicketById(ticket.getTicketId());
		byte[] _file = file.getBytes();
		String id = Integer.toString(ticket.getTicketId());
		String fileDownloadUri = null;
		if (file != null) {
			fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(id)
					.toUriString();
			// add file related information
			toUpdate.setDownloadLink(fileDownloadUri);
			//update all the details sent by admin.
			ticketdao.processTicketRequest(ticket.getRemarks(), ticket.getStatus(), _file, ticket.getTicketId());
		}
		//return file url.
		JSONObject json = new JSONObject();
		json.append("download url", fileDownloadUri);
		return json;

	}

}
