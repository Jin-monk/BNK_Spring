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
	<h1>Show Member Page</h1>
	<hr>
	
	<table border = "1">
		<thead>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>PW</th>
				<th>NAME</th>
				<th>PHONE</th>
				<th>GRADE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${memberList }" varStatus="status"> 
				<tr>
					<td>${status.count }</td>
					<td>${member.id}</td>
					<td>${member.pw}</td>
					<td>${member.name}</td>
					<td>${member.phone}</td>
					<td>${member.grade}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>