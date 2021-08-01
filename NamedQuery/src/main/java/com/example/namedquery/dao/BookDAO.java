package com.example.namedquery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.namedquery.model.Book;
@Repository
public interface BookDAO extends CrudRepository<Book, Integer>{

	public List<Book> findAllBookBybookId(int bookId);
}
