package com.example.ticketbookingapplication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ticketbookingapplication.model.Ticket;
import com.example.ticketbookingapplication.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner {
	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setPassangerName("Raju");
		ticket.setSourceStationName("BNG");
		ticket.setDestinationName("HBL");
		ticket.setEmail("mpshridhar2016@gmail.com");
		ticket.setDate(new Date());
		ticketService.createTicket(ticket);
	}
}
