<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>등록</h1>
	<hr>
	<form action="/toExam" method="POST">
		이름<input type="text" name="name"><br> 
		생년월일<input type="text" name="birthDate"><br> 
		성별<input type="text" name="gender"><br> 
		<input type="submit" value="시작">
	</form>
	<hr>
	<a href="/toExam">시험 </a>
</body>
</html>