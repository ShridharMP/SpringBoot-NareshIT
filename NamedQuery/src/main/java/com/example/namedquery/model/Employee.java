package com.example.namedquery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = {
		@NamedQuery(name = "Employee.searhMaxSalaryEmployee", query = "select e.department,max(e.salary) FROM Employee e"
				+ " GROUP BY e.department HAVING e.department in ?1"),

		/*No converter found capable of converting from type [com.example.namedquery.model.EmployeeCustomType] to type [com.example.namedquery.model.Employee]
		 * @NamedQuery(name = "Employee.searhCustomMaxSalaryEmployee", query =
		 * "select new com.example.namedquery.model.EmployeeCustomType(e.department, max(e.salary)) FROM Employee e"
		 * + " GROUP BY e.department HAVING e.department in ?1")
		 */
})
@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "E_name")
	private String name;
	@Column(name = "E_salary")
	private double salary;
	@Column(name = "dept_name")
	private String department;

	public Employee() {
	}

	public Employee(int id, String name, double salary, String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartmentId() {
		return department;
	}

	public void setDepartmentName(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

	public static Employee create(String name, String department, double salary) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDepartmentName(department);
		employee.setSalary(salary);
		return employee;

	}
}
