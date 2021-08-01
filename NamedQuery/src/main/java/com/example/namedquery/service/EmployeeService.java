package com.example.namedquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.namedquery.dao.EmployeeDAO;
import com.example.namedquery.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	public Iterable<Employee> createEmployee(List<Employee> employeeList) {
		return employeeDAO.saveAll(employeeList);
	}

	public List<Object[]> searhMaxSalaryEmployee(List<String> departList) {
		return employeeDAO.searhMaxSalaryEmployee(departList);
	}

	/*
	 * public List<Employee> searhCustomMaxSalaryEmployee(List<String> departList) {
	 * return employeeDAO.searhCustomMaxSalaryEmployee(departList); }
	 */

}
