<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar empleados</title>
</head>
<body>
	<h3>INTRODUCE DNI DEL EMPLEADO A MODIFICAR</h3>
	<form:form method="POST" action="08_modificado.htm">
		<table>
			<tr>
				<td><label for="dni">DNI</label> <input type="text" name="dni" /></td>
			</tr>
			<tr>
				<td><label for="nombre">NOMBRE (EN CASO DE CAMBIO)</label> <input
					type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td><label for="sexo">SEXO (EN CASO DE CAMBIO)</label> <input
					type="text" name="sexo" /></td>
			</tr>
			<tr>
				<td><label for="categoria">CATEGORIA (EN CASO DE
						CAMBIO)</label> <input type="text" name="categoria" /></td>
			</tr>
			<tr>
				<td><label for="anios">ANIOS (EN CASO DE CAMBIO)</label> <input
					type="text" name="anios" /></td>
			</tr>


		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>


	<h2>Empleados</h2>
	<table border=1>
		<tbody>
			<tr>
				<th>NOMBRE</th>
				<th>DNI</th>
				<th>SEXO</th>
				<th>CATEGORIA</th>
				<th>ANIOS</th>
			</tr>
			<c:forEach items="${model.employees}" var="employee">
				<tr>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.dni}" /></td>
					<td><c:out value="${employee.sex}" /></td>
					<td><c:out value="${employee.category}" /></td>
					<td><c:out value="${employee.years}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="01_entrar.htm">
		<button>Atras</button>
	</a>
</body>
</html>