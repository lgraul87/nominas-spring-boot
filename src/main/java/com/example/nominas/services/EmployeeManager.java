package com.example.nominas.services;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.nominas.domain.Employee;

public interface EmployeeManager extends Serializable{

	public List<Employee> getEmployees();

	public void upDate(HttpServletRequest request, HttpServletResponse response);

	
}
