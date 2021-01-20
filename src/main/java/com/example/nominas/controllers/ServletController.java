package com.example.nominas.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.nominas.services.EmployeeManager;
import com.example.nominas.services.PayrollManager;

@Controller
public class ServletController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private EmployeeManager employeeManager;

	@Autowired
	private PayrollManager payrollManager;

	@RequestMapping(value = "/00_menuEntrada.htm")
	public ModelAndView handleRequestindex(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("00_menuEntrada");
	}

	@RequestMapping(value = "/01_entrar.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Devolviendo entrar view");
		return new ModelAndView("01_entrar");
	}

	@RequestMapping(value = "/02_demo.htm")
	public ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Devolviendo demo view");
		return new ModelAndView("02_demo");
	}

	@RequestMapping(value = "/03_salir.htm")
	public ModelAndView handleRequest3(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Devolviendo salir view");
		return new ModelAndView("03_salir");
	}

	// ################### MOSTRAR EMPLEADOS ##############################
	@RequestMapping(value = "/04_mostrarEmpleados.htm")
	public ModelAndView handleRequest4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("employees", this.employeeManager.getEmployees());

		logger.info("Devolviendo mostrarEmpleados view");
		return new ModelAndView("04_mostrarEmpleados", "model", myModel);
	}

	// ################### MOSTRAR SALARIO POR DNI ########################
	@RequestMapping(value = "/05_mostrarSalario.htm")
	public ModelAndView handleRequest5(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Devolviendo mostrarSalario view");
		return new ModelAndView("05_DNI_formulario_mostrarSalario");
	}

	@RequestMapping(value = "/05_mostrarSalarioDefinido.htm")
	public ModelAndView handleRequest5Definido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Devolviendo mostrarSalario view");
		String dni = request.getParameter("dni");
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("salary", this.payrollManager.getSalary(dni));
		myModel.put("dni", dni);

		return new ModelAndView("07_mostrarSalario", "model", myModel);
	}

	// ################### MODIFICAR EMPLEADO ##############################
	@RequestMapping(value = "/06_modificarEmpleado.htm")
	public ModelAndView handleRequest6(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("employees", this.employeeManager.getEmployees());

		logger.info("Devolviendo mostrarEmpleados view");
		return new ModelAndView("06_modificarEmpleado", "model", myModel);
	}
	@RequestMapping(value = "/08_modificado.htm")
	public ModelAndView handleRequest8(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.employeeManager.upDate(request,response);
		String s ="";
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("employees", this.employeeManager.getEmployees());

		logger.info("Devolviendo mostrarEmpleados view");
		return new ModelAndView("08_modificado", "model", myModel);
	}
	
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

}
