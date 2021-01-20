package com.example.nominas.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.nominas.domain.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository(value = "employeeDao")
public class JPAEmployeeDAO implements EmployeeDao {

	private EntityManager em = null;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() {
		return em.createQuery("select e from Employee e order by e.id").getResultList();
	}

	@Transactional(readOnly = false)
	public void upDate(Employee oEmployee) {

		String query = createQuery(oEmployee);

		em.createQuery(query).executeUpdate();
	}

	@Transactional(readOnly = false)
	public void saveEmployee(Employee employee) {
		em.merge(employee);
	}

	private String createQuery(Employee oEmployee) {
		boolean nam = false;
		boolean sec = false;
		boolean cat = false;
		int category = -1;
		int years = -1;

		String query = "update Employee set";
		String dni = oEmployee.getDni();
		String name = oEmployee.getName();
		String sex = oEmployee.getSex();
		int oCategory = oEmployee.getCategory();
		int oYears = oEmployee.getYears();

		try {
			category = Integer.valueOf(oCategory);

		} catch (Exception e) {
			category = -1;
		}

		try {
			years = Integer.valueOf(oYears);
		} catch (Exception e) {
			years = -1;
		}

		if (name != "") {
			query += " name = '" + name + "'";
			nam = true;
		}

		if (sex != "" && nam) {
			query += ", sex = '" + sex + "'";
			sec = true;
		} else if (sex != "") {
			query += " sex = '" + sex + "'";
			sec = true;

		}

		if (category != -1 && nam || category != -1 && sec) {
			query += ", category = " + category + "";
			cat = true;

		} else if (category != -1) {
			query += " category = " + category + "";
			cat = true;

		}
		if (years != -1 && nam || years != -1 && sec || years != -1 && cat) {
			query += ", years = " + years + "";

		} else if (years != -1) {
			query += " years = " + years + "";
		}

		query += "  where dni = '" + dni + "'";

		return query;
	}

}