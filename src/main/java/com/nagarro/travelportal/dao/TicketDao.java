package com.nagarro.travelportal.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.travelportal.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer>{
	//@Query("select ticket from Ticket ticket where ticket.employee_username = ?1")
	@Query("FROM Ticket where employee_username =:username")
    List<Ticket> findByUsername(String username) throws NoSuchElementException;
	
	@Query("SELECT t.employee.username FROM Ticket t WHERE t.ticketId =:id")
	String ticketRaiseBy(Integer id) ;
	
}
