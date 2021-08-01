package com.example.person.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.person.model.Person;

@Repository
public interface PersonDAO extends CrudRepository<Person, Integer> {

	public List<Person> findByLastName(String lname);
	
	public List<Person> findByFirstNameAndLastName(String firstName,String lastName);
	
	public List<Person> findByFirstNameOrLastName(String firstName,String lastName);
	
	public List<Person> findByLastNameOrderByDateDesc(String lastName);
	
	public List<Person> findByAgeLessThanEqual(Integer age);
	
	public List<Person> findByFirstNameLike(String firstName);
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,Integer age);
	
	public List<Person> findByDateBetween(Date startDate,Date endDate);
	
	public List<Person> searchByLastName(String lname);
	
	public List<Object> giveFewColumns(String lname);
	

}
