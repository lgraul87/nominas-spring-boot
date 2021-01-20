<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Empleado modificado</h2>
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