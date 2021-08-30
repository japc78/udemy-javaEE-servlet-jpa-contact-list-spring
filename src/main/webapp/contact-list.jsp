<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
</head>
<body>
	
	<div class="container">
		<div >
			<table border="1" class="table table-striped table-bordered" >
				<thead><tr><th>Name</th><th>Email</th><th>Phone Number</th><th></th></tr></thead>
				<tbody>
					<c:forEach var="contact" items="${requestScope.contacts}">
						<tr>
							<td>${contact.name}</td>
							<td>${contact.email}</td>
							<td>${contact.phoneNumber}</td>
							<td><a href="delete?id=${contact.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>	
			</table>
		</div>
		<br/><br/>	
		<a href="back">Back</a>
	</div>
</body>
</html>