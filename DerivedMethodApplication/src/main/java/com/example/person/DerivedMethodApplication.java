package com.example.person;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.person.model.Person;
import com.example.person.service.PersonService;

@SpringBootApplication
public class DerivedMethodApplication implements CommandLineRunner {

	@Autowired
	PersonService personService;
	
	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createPersons();
		//findAllByListOfIds();
		//findByLastName();
		//findByFirstNameAndLastName();
		//findByFirstNameOrLastName();
		//findByLastNameOrderByDateDesc();
		//findByAgeLessThanEqual();
		//findByFirstNameLike();
		//findByLastNameAndAgeLessThanEqual();
		//findByDateBetween();
		//searchByLastName();
		giveFewColumns();
	}
	
	private void giveFewColumns() {
		List<Object> listOfPersons = personService.giveFewColumns("Patil");
		for (Object person : listOfPersons) {
			System.out.println(person.toString());
		}
	}

	private void searchByLastName() {
		List<Person> listOfPersons = personService.searchByLastName("Patil");
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}
	}

	/*
	 * private void findByDateBetween() { List<Person> listOfPersons =
	 * personService.findByDateBetween(getDateWithTime("2021-07-11 00:01:30"),
	 * getDateWithTime("2021-07-12 00:01:30")); for (Person person : listOfPersons)
	 * { System.out.println(person.toString()); }
	 * 
	 * }
	 */

	
	private void findByDateBetween() {
		List<Person> listOfPersons = personService.findByDateBetween(getDate("2021-07-11"),getDate("2021-07-12"));
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}
		
	}
	private void findByLastNameAndAgeLessThanEqual() {
		List<Person> listOfPersons = personService.findByLastNameAndAgeLessThanEqual("Patil",60);
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}

		
	}

	private void findByFirstNameLike() {
		List<Person> listOfPersons = personService.findByFirstNameLike("Sh");
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}

	}

	private void findByAgeLessThanEqual() {
		List<Person> listOfPersons = personService.findByAgeLessThanEqual(50);
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}

	}

	private void findByLastNameOrderByDateDesc() {
		List<Person> listOfPersons = personService.findByLastNameOrderByDateDesc("Patil");
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}
	}

	private void findByFirstNameOrLastName() {
		List<Person> listOfPersons = personService.findByFirstNameOrLastName("Shridhar", "Patil");
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}

	}

	private void findByFirstNameAndLastName() {
		List<Person> listOfPersons = personService.findByFirstNameAndLastName("Shridhar", "Patil");
		for (Person person : listOfPersons) {
			System.out.println(person.toString());
		}

	}

	private void findByLastName() {
		List<Person> listofPersons = (List<Person>) personService.findByLastName("Patil");
		for (Person person : listofPersons) {
			System.out.println("Person Details " + person.toString());
		}

	}

	private void findAllByListOfIds() {
		List<Integer> listOfIds = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
		Iterable<Person> listofPersons = personService.findAllByID(listOfIds);
		for (Person person : listofPersons) {
			System.out.println(person.toString());
		}
	}

	private void createPersons() {

		List<Person> listOfPersons = Arrays.asList(
				new Person("Shridhar", "Patil", "pshridhar4@gmail.com", 28, new Date(), 66),
				new Person("Shridhar", "Biradar", "pshridhar4@gmail.com", 25, new Date(), 25),
				new Person("Sangu", "Kademani", "Sangu@gmail.com", 63, new Date(), 35),
				new Person("Siddu", "Doddamani", "Siddu@gmail.com", 97, new Date(), 28),
				new Person("Gundu", "Bayimani", "Gundu@gmail.com", 70, new Date(), 18),
				new Person("Sangu", "Hosagodru", "Sangu@gmail.com", 18, new Date(), 46),
				new Person("Prabhu", "Kulakarni", "Prabhu@gmail.com", 23, new Date(), 66),
				new Person("Shrikant", "Hachareddi", "Shrikant@gmail.com", 30, new Date(), 43),
				new Person("Shrikant", "PatilKulakarni", "ShrikantPatilKulakarni@gmail.com", 32, new Date(), 90));

		Iterable<Person> listofPersons = personService.saveAll(listOfPersons);

		for (Person person : listofPersons) {
			System.out.println(person.toString());
		}
	}
	
	private Date getDate(String dateString)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Date getDateWithTime(String dateString)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}


}
