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
<title>FORMULARIO DNI</title>
</head>
<body>
	<h3>INTRODUCE DNI</h3>
	<form:form method="POST" action="05_mostrarSalarioDefinido.htm">
		<table>
			<tr>
				<td><input type="text" name="dni" /></td>
			</tr>

		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	
</body>
</html>