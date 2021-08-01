package com.example.namedquery.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = {
		@NamedQuery(name = "Book.findAllBookBybookId", query = "select distinct b from Book b Join b.publishers p where b.id=?1") })
@Entity
@Table(name = "Book")
public class Book {

	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "book_name")
	private String bookName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"), inverseJoinColumns = @JoinColumn(name = "publish_id", referencedColumnName = "publish_id"))
	private Set<Publisher> publishers;

	public Book() {
	}

	public Book(int id, String bookName, Set<Publisher> publishers) {
		this.id = id;
		this.bookName = bookName;
		this.publishers = publishers;
	}

	public Book(String bookName, HashSet<Publisher> publishers) {
		this.bookName = bookName;
		this.publishers = publishers;
	}

	public int getBid() {
		return id;
	}

	public void setBid(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	@Override
	public String toString() {

		String result = String.format("Book data [id=%d,name='%s']%n", id, bookName);
		if (publishers != null) {
			for (Publisher publisher : publishers) {
				result += String.format("Publisher [id=%d,name='%s']%n", publisher.getId(),
						publisher.getPublisherName());
			}
		}
		return result;
	}
}
