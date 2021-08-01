package com.example.namedquery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.namedquery.model.Book;
import com.example.namedquery.model.Employee;
import com.example.namedquery.model.Publisher;
import com.example.namedquery.service.BookService;
import com.example.namedquery.service.EmployeeService;

@SpringBootApplication
public class DerivedMethodApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// saveAllBooksAndPublisher();
		// getAllPublisher();
		// getBookByBookID();
		// createEmployee();
		searhMaxSalaryEmployee();
		//searhCustomMaxSalaryEmployee();
	}

	/*
	 * private void searhCustomMaxSalaryEmployee() { List<Employee> employeeList =
	 * employeeService .searhCustomMaxSalaryEmployee(Arrays.asList("Development",
	 * "Testing", "Devops")); for (Employee employee : employeeList) {
	 * System.out.println(employee.toString()); }
	 * 
	 * }
	 */

	private void searhMaxSalaryEmployee() {
		List<Object[]> employeeList = employeeService
				.searhMaxSalaryEmployee(Arrays.asList("Development", "Testing", "Devops"));
		employeeList.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});
	}

	private void createEmployee() {
		List<Employee> employeeListObject = Arrays.asList(Employee.create("Shridhar", "Development", 15000),
				Employee.create("Darshan", "Development", 20000),

				Employee.create("Brahmanand", "Testing", 30000), Employee.create("Darshan", "Testing", 35000),

				Employee.create("Devaraj", "Security", 25000), Employee.create("Girish", "Devops", 20000),

				Employee.create("Punith Kr ", "FullStack", 35000), Employee.create("Nithin G B", "DB", 28000));
		Iterable<Employee> employeeList = employeeService.createEmployee(employeeListObject);
		for (Employee employee : employeeList) {
			System.out.println(employee.toString());
		}

	}

	private void getBookByBookID() {
		Iterable<Book> books = bookService.findAllBookBybookId(2);
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	private void getAllPublisher() {
		Iterable<Book> books = bookService.getAllPublisher();
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	private void saveAllBooksAndPublisher() {
		Publisher publisherA = new Publisher("AbdulKalam");
		Publisher publisherB = new Publisher("Shridhar");
		Publisher publisherC = new Publisher("ChetanBhagat");
		Publisher publisherD = new Publisher("Author1");
		Publisher publisherE = new Publisher("Author2");
		Publisher publisherF = new Publisher("Nazaar");

		Book bookA = new Book("WingsOfFire", new HashSet<>(Arrays.asList(publisherA)));
		Book bookB = new Book("SevenHabits", new HashSet<>(Arrays.asList(publisherB)));
		Book bookC = new Book("TwoStates", new HashSet<>(Arrays.asList(publisherC)));
		Book bookD = new Book("Book2", new HashSet<>(Arrays.asList(publisherD, publisherE)));
		Book bookE = new Book("Book5", new HashSet<>(Arrays.asList(publisherF)));
		Book bookF = new Book("Book6", new HashSet<>(Arrays.asList(publisherF)));

		Iterable<Book> books = bookService.saveAll(Arrays.asList(bookA, bookB, bookC, bookD, bookE, bookF));
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
}
