package com.example.namedquery.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Publisher")
public class Publisher {
	@Id
	@Column(name = "publish_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "publisher_name")
	private String publisherName;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "publishers")
	private Set<Book> books;

	public Publisher() {

	}

	public Publisher(int id, String publisherName, Set<Book> books) {
		this.id = id;
		this.publisherName = publisherName;
		this.books = books;
	}

	public Publisher(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
