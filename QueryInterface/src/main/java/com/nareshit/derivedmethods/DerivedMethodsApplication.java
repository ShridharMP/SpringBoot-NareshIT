package com.nareshit.derivedmethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.derivedmethods.model.Book;
import com.nareshit.derivedmethods.model.Employee;
import com.nareshit.derivedmethods.model.Person;
import com.nareshit.derivedmethods.model.Publisher;
import com.nareshit.derivedmethods.service.PersonService;

@SpringBootApplication
public class DerivedMethodsApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;



	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createPersons();
		//getPersonByIds();
		//findByLastName();
		//findByFirstNameAndLastName();
		//findByFirstNameOrLastName();
		//findByLastNameOrderByCreationDateDesc();
		//findByAgeLessThanEqual();
		//findByLastNameAndAgeLessThanEqual();
		//findByFirstNameLike();
		//findByCreatedDateBetween();
		//findByCreatedDateBetweenwithTime();
		//searchpersonbyLastname();
		//saveBookPublishers();
		//getBookDetails();
		//givefewcolumns();
		//createEmployees();

		findMaxSalariesbyDept();
	}
	private void findMaxSalariesbyDept() {
		System.out.println(" -- finding max salaries in Admin and IT depts  --");
		List<Object[]> list = personService.findMaxSalariesByDept
				(Arrays.asList("Admin", "IT","HR"));
		list.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});
	}

	private void createEmployees() {
		List<Employee> empList = Arrays.asList(
				Employee.create("Ram", "Admin", 2000),
				Employee.create("Gopi", "Admin", 3500),
				Employee.create("Bhanu", "Admin", 10000),

				Employee.create("Sita", "Sale", 1000),
				Employee.create("Ganesh", "Sale", 3000),
				Employee.create("Deepak", "Sale", 40000),

				Employee.create("Laxman", "IT", 4000),
				Employee.create("Seenu", "IT", 2500),
				Employee.create("Akshay", "IT", 25000),

				Employee.create("Swathi", "HR", 8000),
				Employee.create("Sneha", "HR", 6500),
				Employee.create("Spandana", "HR", 65000)


				);

		Iterable<Employee> list = personService.createEmployees(empList);
		for (Employee emp : list) {
			System.out.println("Employee Object" + emp.toString());

		}
	}

	private void givefewcolumns() {
		Iterable<Object> personList = personService.givefewcolumns("kumar");

		for (Object person : personList) {
			System.out.println(person.toString());
		}
	}


	private void getBookDetails() {

		//select * from book join book_publisher join publisher on
		//book.id=book_publisher.book_id
		// and publisher.id=book_publisher.publisher_id where book.id=4

		List<Book> bookList = personService.findAllBookBybookId(4);
		for (Book book : bookList) {

			System.out.println("Book Object" + book.toString());
		}
	}


	private void saveBookPublishers() {

		Publisher publisherA = new Publisher("AbdulKalam");
		Publisher publisherB = new Publisher("Stephen Kovey");
		Publisher publisherC = new Publisher("ChetanBagath");
		Publisher publisherD = new Publisher("Author2");
		Publisher publisherE = new Publisher("Author3");
		Publisher publisherF = new Publisher("Nazir");


		Book bookA = new Book("WingsofFire", new HashSet<>(Arrays.asList(publisherA)));
		Book bookB = new Book("SevenHabits", new HashSet<>(Arrays.asList(publisherB)));
		Book bookC = new Book("TwoStates", new HashSet<>(Arrays.asList(publisherC)));
		Book bookD=new Book("Book2",new HashSet<>(Arrays.asList(publisherD, publisherE)));
		Book bookE=new Book("Book5",new HashSet<>(Arrays.asList(publisherF)));
		Book bookF=new Book("Book6",new HashSet<>(Arrays.asList(publisherF)));


		 personService.saveAllBooks(Arrays.asList(bookA, bookB,bookC,bookD,bookE,bookF));

		// bookService.saveBooks(Arrays.asList(bookA, bookB));

		// fetch all publishers
		for (Book book : personService.getAllBooks()) {
			System.out.println(book.toString());
		}

	}

	private void searchpersonbyLastname() {
		Iterable<Person> personList = personService.searchpersonbyLastname("kumar");

		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}



	private void findByFirstNameLike() {
		Iterable<Person> personList = personService.findByFirstNameLike("%Kiran%");

		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}

	private void findByLastNameAndAgeLessThanEqual() {
		Iterable<Person> personsList = personService.
				findByLastNameAndAgeLessThanEqual("kumar",40);

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	// findByAgeLessThanEqual

	private void findByAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByAgeLessThanEqual(40);

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	// findByLastNameOrderByCreationDateDesc
	private void findByLastNameOrderByCreationDateDesc() {
		Iterable<Person> personsList = personService.
				findByLastNameOrderByCreatedDateDesc("kumar");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void createPersons() {

		/*
	List<Person> personsList= new ArrayList<Person>();

	Person per=new Person("Kiran", "kumar", "kiran@gmail.com", 20);
	personsList.add(per);

	Person per2=new Person("Ram", "kumar", "ram@gmail.com", 22);
	personsList.add(per2);

*/



		List<Person> personList = Arrays.asList(
				new Person("Kiran", "kumar", "kiran@gmail.com", 20),
				new Person("Ram", "kumar", "ram@gmail.com", 22),
				new Person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new Person("KiranKiran", "kumar", "kiran@gmail.com", 20),
				new Person("RamRam", "kumar", "ram@gmail.com", 22),
				new Person("RamKiranRamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("RamKiranRamKiran", "Seth", "seth@gmail.com", 50),
				new Person("SitaSita", "Kumar", "lakshman@gmail.com", 50),
				new Person("GaneshSita", "Kumar", "ganesh@gmail.com", 50)
				);

		Iterable<Person> list = personService.saveAllPersons(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void getPersonByIds() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		Iterable<Person> personsList = personService.getPersonsByIds(personList);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByLastName() {
		List<Person> personList = personService.findByLastName("Seth");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		Person person = personService.findByFirstNameAndLastName("Ram", "kumar");

		System.out.println("Person Object" + person.toString());

	}

	private void findByFirstNameOrLastName() {
		List<Person> personList = personService.findByFirstNameOrLastName("Ram", "kumar");

		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void findByCreatedDateBetweenwithTime() {
		//2021-03-16 21:38:29.168
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDatewithTime("2021-03-16 21:38:27"),
				getDatewithTime("2021-03-16 21:38:30"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}


	private void findByCreatedDateBetween() {
		//
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDate("2021-03-16"),
				getDate("2021-03-18"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}


	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}


	private Date getDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private Date getDate(String dateString, int add) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date current = format.parse(dateString);

			Calendar cal = Calendar.getInstance();
			cal.setTime(current);
			cal.add(Calendar.DATE, add);

			return cal.getTime();
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}
}
