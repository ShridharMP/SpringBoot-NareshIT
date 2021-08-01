package com.example.namedquery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.namedquery.model.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

	public List<Object[]> searhMaxSalaryEmployee(List<String> departList);
	
	/*
	 * public List<Employee> searhCustomMaxSalaryEmployee(List<String> departList);
	 */
	
}
