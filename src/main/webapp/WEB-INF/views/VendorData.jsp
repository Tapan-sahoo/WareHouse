<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Gray">
	<h1 style="color: red; text-align: center">Welcome to Vendor Data
		Page</h1>
		<a href="excel">Excel Export</a> | | <a href="pdf"> PDF Export</a><br> 
	<table border="1" cellspacing="4" cellpadding="4"
align="center" style="background-color: Red;color: yellow;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>CODE</th>
			<th>DESIGNATION</th>
			<th>PRESERVE</th>
			<th colspan=2>OPERATIONS</th>
		</tr>

		<c:forEach items="${list}" var="vd">
			<tr>
				<td><c:out value="${vd.venId}" /></td>
				<td><c:out value="${vd.venName}" /></td>
				<td><c:out value="${vd.venCode}" /></td>
				<td><c:out value="${vd.venDesg}" /></td>
				<td><c:out value="${vd.venPreserve}" /></td>

				<td><a href="delete?id=${vd.venId}">DELETE</a></td>
				<td><a href="edit?id=${vd.venId}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	Vendor::${message}

</body>
</html>