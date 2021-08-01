package com.example.ticketbookingapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbookingapplication.model.Ticket;
import com.example.ticketbookingapplication.service.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketBookingController {

	@Autowired
	TicketService ticketService;

	// http://localhost:8080/tickets/create
	@PostMapping("/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}

	// http://localhost:8080/tickets/getall
	@GetMapping("/getall")
	public Iterable<Ticket> getAllTicket(Ticket ticket) {
		return ticketService.getAllTicket();
	}

	@GetMapping("/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicketById(ticketId);
	}

	@PutMapping("/{ticketId}/{newEmail}")
	public Ticket updateTicketById(@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicketById(ticketId, newEmail);
	}

	@DeleteMapping("/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}

}
