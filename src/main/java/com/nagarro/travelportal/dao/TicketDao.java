package com.nagarro.travelportal.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.travelportal.model.Ticket;


/**
 * The Interface TicketDao.
 */
public interface TicketDao extends JpaRepository<Ticket, Integer>{
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the list
	 * @throws NoSuchElementException the no such element exception
	 */
	@Query("FROM Ticket where employee_username =:username")
    List<Ticket> findByUsername(String username) throws NoSuchElementException;
	
	/**
	 * Ticket raise by.
	 *
	 * @param id the id
	 * @return the string
	 */
	@Query("SELECT t.employee.username FROM Ticket t WHERE t.ticketId =:id")
	String ticketRaiseBy(Integer id) ;
	
	

}
