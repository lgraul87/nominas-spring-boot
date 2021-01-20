package com.example.nominas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.nominas.domain.Payroll;

@Repository(value = "payrollDao")
public class JPAPayrollDao implements PayrollDao{

	private EntityManager em = null;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	public float getSalary(String dni) {
		return  (float) em.createQuery("select salary from Payroll where dni = '"+dni+"'").getSingleResult();
	}

	@Transactional(readOnly = false)
	public void savePayroll(Payroll payroll) {
		em.merge(payroll);
	}
}
