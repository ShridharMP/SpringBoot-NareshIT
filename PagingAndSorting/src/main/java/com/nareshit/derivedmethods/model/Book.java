package com.nareshit.derivedmethods.model;

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

@Entity
@Table(name="tbl_book")
@NamedQueries(value = {


		//select * from book b join book_publisher bp on bp.book_id=b.id
		//inner join publisher p on bp.publisher_id=p.id where b.id=?

		@NamedQuery(name = "Book.findAllBookBybookId",
				query = "SELECT  DISTINCT b from Book b  Join b.publishers   p where b.id=?1 ")

})
public class Book {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="book_name")
	private String bookName;

	//Here we defined entire many to many releation

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "book_publishers",
		joinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name="publisher_id",referencedColumnName = "id"))
	private Set<Publisher> publishers;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Set<Publisher> getPublisher() {
		return publishers;
	}


	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}


	public Book( String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}

	public Book() {}


	@Override
	public String toString() {

		String result = String.format("Book Data  [id=%d,name='%s']%n", id, bookName);
		// Book Data[id=1,name='Book A']

		if (publishers != null)
			for (Publisher publisher : publishers) {

				result += String.format("Publisher [id=%d,name='%s']%n", publisher.getId(),
						publisher.getPublisherName());
			}

		return result;

	}


}
