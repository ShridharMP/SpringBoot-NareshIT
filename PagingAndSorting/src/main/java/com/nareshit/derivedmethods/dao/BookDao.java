package com.nareshit.derivedmethods.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethods.model.Book;

@Repository
public interface BookDao  extends CrudRepository<Book, Integer>{


	//Abstract Method for a named query method which will retieve a particular
	//book from book table.
	public List<Book> findAllBookBybookId(int bookId);
}
