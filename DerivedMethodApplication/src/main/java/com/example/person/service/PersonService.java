package com.example.person.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.person.dao.PersonDAO;
import com.example.person.model.Person;

@Service
public class PersonService {
	@Autowired
	public PersonDAO personDAO;

	public Iterable<Person> saveAll(Iterable<Person> listOfPersons) {
		return personDAO.saveAll(listOfPersons);
	}

	public Iterable<Person> findAllByID(Iterable<Integer> listOfIds) {
		return personDAO.findAllById(listOfIds);
	}

	public List<Person> findByLastName(String lname) {

		return personDAO.findByLastName(lname);
	}

	public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
		return personDAO.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<Person> findByFirstNameOrLastName(String firstName, String lastName) {
		return personDAO.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Person> findByLastNameOrderByDateDesc(String lastName) {
		return personDAO.findByLastNameOrderByDateDesc(lastName);
	}

	public List<Person> findByAgeLessThanEqual(Integer age) {
		return personDAO.findByAgeLessThanEqual(age);
	}

	public List<Person> findByFirstNameLike(String firstName) {
		return personDAO.findByFirstNameLike(firstName);
	}

	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, Integer age) {
		return personDAO.findByLastNameAndAgeLessThanEqual(lastName, age);
	}

	public List<Person> findByDateBetween(Date startDate, Date endDate) {
		return personDAO.findByDateBetween(startDate, endDate);
	}

	public List<Person> searchByLastName(String lname) {
		return personDAO.searchByLastName(lname);
	}
	
	public List<Object> giveFewColumns(String lname) {
		return personDAO.giveFewColumns(lname);
	}
	
}
