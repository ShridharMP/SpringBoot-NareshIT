package com.example.namedquery.model;

public class EmployeeCustomType {

	private String departmentName;
	private double salary;

	public EmployeeCustomType() {

	}

	public EmployeeCustomType(String departmentName, double salary) {
		this.departmentName = departmentName;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "EmployeeCustomType [departmentName=" + departmentName + ", salary=" + salary + "]";
	}
}
