<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Info Page</h1>
	<hr>
	<br>
	<hr>
	<form action="updateinfo" method="POST">
		ID: <input type="text" name="id" value ="${member.id}" readonly><br> 
		PW: <input type="text" name="pw" value ="${member.pw}"><br> 
		NAME: <input type="text" name="name" value ="${member.name}"><br> 
		PHONE: <input type="text" name="phone" value ="${member.phone}"><br>
		GRADE: <input type="text" name="grade" value ="${member.grade}" readonly><br> 
		<input type="submit" value="전송">
	</form>
	
	<a href="/">홈으로</a>
</body>
</html>