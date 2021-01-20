package com.example.nominas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nominas.repository.PayrollDao;

@Component
public class SimplePayrollManager implements PayrollManager{

    private static final long serialVersionUID = 1L;

	
	@Autowired
	private PayrollDao payrollDao;
	
	

	public void setPayrollDao(PayrollDao payrollDao) {
		this.payrollDao = payrollDao;
	}

	

	@Override
	public float getSalary(String dni) {
		return payrollDao.getSalary(dni);
	}

}
