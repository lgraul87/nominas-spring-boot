package com.example.nominas.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nominas.domain.Employee;
import com.example.nominas.repository.EmployeeDao;

@Component
public class SimpleEmployeeManager implements EmployeeManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeDao employeeDao;
	
	

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getEmployees() {
		return employeeDao.getEmployeeList();
	}

	@Override
	public void upDate(HttpServletRequest request, HttpServletResponse response) {

		
		
		 Employee oEmployee = new Employee();
		
		int categoria = -1;
		int years = -1;

		
		oEmployee.setDni(request.getParameter("dni"));
		oEmployee.setName(request.getParameter("nombre"));
		oEmployee.setSex(request.getParameter("sexo"));

		try {
			categoria = Integer.parseInt(request.getParameter("categoria"));
		} catch (Exception e) {
			categoria = -1;
		}
		try {
			years = Integer.parseInt(request.getParameter("anios"));
		} catch (Exception e) {
			years = -1;
		}
		oEmployee.setCategory(categoria);
		oEmployee.setYears(years);
		
		employeeDao.upDate(oEmployee);

	}

}
