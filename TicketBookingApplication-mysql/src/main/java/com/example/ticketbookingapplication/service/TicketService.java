package com.example.ticketbookingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketbookingapplication.DAO.TicketDAO;
import com.example.ticketbookingapplication.model.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDAO ticketDao;

	// Create Ticket
	public Ticket createTicket(Ticket ticket) {
		return ticketDao.save(ticket);
	}

	// ReadTickets

	public Iterable<Ticket> getAllTicket() {
		return ticketDao.findAll();
	}

	// ReadTicket
	public Ticket getTicketById(Integer ticketId) {
		return ticketDao.findById(ticketId).orElse(new Ticket());
	}

	// updateTicket By Id
	public Ticket updateTicketById(Integer ticketId, String newEmail) {
		Ticket ticket = getTicketById(ticketId);
		ticket.setEmail(newEmail);
		return ticketDao.save(ticket);
	}

	// Delete Ticket
	public void deleteTicket(Integer ticketId) {
		ticketDao.deleteById(ticketId);
	}
}
