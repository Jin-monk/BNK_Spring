<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>UserList Page</h1>
	<hr>

	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>id</th>
				<th>name</th>
				<th>role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${list }" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.role}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<h3>2개 모두 입력해야 검색 가능</h3>
	<form action="/user/searchUser" method="GET">
		이름: <input type="text" name="name"><br>
		등급: <input type="text" name="role"><br>
		<input type="submit" value="검색">
	</form>
	<hr>
	<h2>1개만 입력해도 검색 가능</h2>
	<form action="/user/searchUser2" method="GET">
		이름: <input type="text" name="name"><br>
		등급: <input type="text" name="role"><br>
		<input type="submit" value="검색">
	</form>
	<hr>
	<h2>Validation 이용한 회원가입</h2>
	<form action="/user/create" method="POST">
		ID: <input type="text" name="id"><br>	
		PW: <input type="text" name="pw"><br>	
		NAME: <input type="text" name="name"><br>	
		<input type="submit" value="가입"><br>	
	</form>
	<br>
	
</body>
</html>