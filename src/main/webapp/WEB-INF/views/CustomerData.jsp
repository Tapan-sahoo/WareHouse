<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body bgcolor="green">
	<h1 style="color: red; text-align: center">Welcome to Customer
		Data Page</h1>
<center><a href="excel">Excel Export</a> | | <a href="pdf"> PDF Export</a><br></center> 
	<table border="1" cellspacing="4" cellpadding="4"
align="center" style="background-color: marron;color: Orange;">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>ADDRESS</th>
			<th>LOCATION</th>
			<th>ENABLED</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th colspan=2>OPERATIONS</th>
		</tr>

		<c:forEach items="${list}" var="c">
			<tr>
				<td><c:out value="${c.custId}" /></td>
				<td><c:out value="${c.custCode}" /></td>
				<td><c:out value="${c.custAddr}" /></td>
				<td><c:out value="${c.custLocs}" /></td>
				<td><c:out value="${c.custEnabled}" /></td>
				<td><c:out value="${c.custEmail}" /></td>
				<td><c:out value="${c.custContact}" /></td>

				<td><a href="delete?id=${c.custId}">DELETE</a></td>
				<td><a href="edit?id=${c.custId}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>