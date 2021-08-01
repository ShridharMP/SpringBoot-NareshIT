package com.example.namedquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.namedquery.dao.BookDAO;
import com.example.namedquery.model.Book;

@Service
public class BookService {

	@Autowired
	public BookDAO bookDAO;

	public Iterable<Book> saveAll(List<Book> books) {
		return bookDAO.saveAll(books);
	}

	public Iterable<Book> getAllPublisher() {
		return bookDAO.findAll();
	}

	public Iterable<Book> findAllBookBybookId(int bookID) {
		return bookDAO.findAllBookBybookId(bookID);
	}
}
