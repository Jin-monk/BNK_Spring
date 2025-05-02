<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Page</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>phone</th>
				<th>grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="datail?id=${member.id}"> ${member.id}</a></td>
				<td>${member.pw}</td>
				<td>${member.name}</td>
				<td>${member.phone}</td>
				<td>${member.grade}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">홈으로</a>
</body>
</html>