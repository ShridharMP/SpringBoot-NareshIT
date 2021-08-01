package com.example.ticketbookingapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;

	@Column(name = "PassngerName")
	private String PassangerName;
	@Column(name = "Src_Station_Name")
	private String sourceStationName;
	@Column(name = "Destination_Name")
	private String destinationName;
	@Column(name = "BookingDate")
	private Date date;
	private String email;

	public Ticket(int ticketId, String passangerName, String sourceStationName, String destinationName, Date date,
			String email) {
		this.ticketId = ticketId;
		PassangerName = passangerName;
		this.sourceStationName = sourceStationName;
		this.destinationName = destinationName;
		this.date = new Date();
		this.email = email;
	}

	public Ticket() {

	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassangerName() {
		return PassangerName;
	}

	public void setPassangerName(String passangerName) {
		PassangerName = passangerName;
	}

	public String getSourceStationName() {
		return sourceStationName;
	}

	public void setSourceStationName(String sourceStationName) {
		this.sourceStationName = sourceStationName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public Date getDate() {
		return date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
