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
	<h2>Mostrar DNI y salario</h2>

	<table border=1>
		<tbody>
			<tr>
				<th>DNI</th>
				<th>SALARIO</th>
			</tr>
			<tr>
				<td><c:out value="${model.dni}" /></td>
				<td><c:out value="${model.salary}" /></td>
			</tr>
		</tbody>
	</table>
	<br>
	<a href="01_entrar.htm">
		<button>Atras</button>
	</a>
</body>
</html>