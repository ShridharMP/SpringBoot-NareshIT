package com.example.namedquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.namedquery.dao.PublishDAO;
import com.example.namedquery.model.Publisher;

@Service
public class PublisherService {
	@Autowired
	PublishDAO publishDAO;

	public Iterable<Publisher> saveAll(List publishers) {
		return publishDAO.saveAll(publishers);
	}

	public Iterable<Publisher> getAllPublisher() {
		return publishDAO.findAll();
	}

}
