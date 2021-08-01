package com.example.ticketbookingapplication.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ticketbookingapplication.model.Ticket;

@Repository
public interface TicketDAO extends CrudRepository<Ticket, Integer> {

}
