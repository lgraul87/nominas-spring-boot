package com.example.nominas.repository;

import java.util.List;



import com.example.nominas.domain.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployeeList();

	public void saveEmployee(Employee employee);

	public void upDate(Employee oEmployee);

}
