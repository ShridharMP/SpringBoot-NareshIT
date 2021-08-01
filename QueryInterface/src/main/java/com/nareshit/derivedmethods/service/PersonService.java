package com.nareshit.derivedmethods.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.derivedmethods.dao.BookDao;
import com.nareshit.derivedmethods.dao.EmployeeDao;
import com.nareshit.derivedmethods.dao.PersonDao;
import com.nareshit.derivedmethods.model.Book;
import com.nareshit.derivedmethods.model.Employee;
import com.nareshit.derivedmethods.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private EmployeeDao empDao;

	public Iterable<Person> saveAllPersons(Iterable<Person> personsList) {
		return personDao.saveAll(personsList);
	}


	public Iterable<Person> getPersonsByIds(List<Integer> personIds){
		return personDao.findAllById(personIds);
	}

	public List<Person> findByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}

	public Person findByFirstNameAndLastName(String firstName, String lastName) {
		return personDao.findByFirstNameAndLastName(firstName,lastName);
	}

	public List<Person> findByFirstNameOrLastName(String firstName, String lastName){
		return personDao.findByFirstNameOrLastName(firstName,lastName);
	}

	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName){
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

	public List<Person> findByAgeLessThanEqual(Integer age){
		return personDao.findByAgeLessThanEqual(age);
	}

	public List<Person> findByFirstNameLike(String firstName){
		return personDao.findByFirstNameLike(firstName);
	}

	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age){
		return personDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	}
	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate){
		return personDao.findByCreatedDateBetween(startdate,endDate);
	}
	public List<Person> searchpersonbyLastname(String lastName){
		return personDao.searchpersonbyLastname(lastName);
	}

	public List<Object> givefewcolumns(String lastName){
		return personDao.givefewcolumns(lastName);
	}
	public Iterable<Book> saveAllBooks(Iterable<Book> books){
		return bookDao.saveAll(books);
	}

	public Iterable<Book> getAllBooks(){
		return bookDao.findAll();
	}

	public List<Book> findAllBookBybookId(int bookId){
		return bookDao.findAllBookBybookId(bookId);
	}


	public Iterable<Employee> createEmployees(List<Employee> empList) {
			return empDao.saveAll(empList);
	}


	public List<Object[]> findMaxSalariesByDept(List<String> deptNames) {
		return    empDao.findMaxSalariesByDept(deptNames);
	}
}
