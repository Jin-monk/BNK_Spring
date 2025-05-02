<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<a href="list">list 페이지 가기</a>
	<br>
	<hr>
	<form action="write" method="POST">
		ID: <input type="text" name="id"><br>
		PW: <input type="text" name="pw"><br>
		NAME: <input type="text" name="name"><br>
		PHONE: <input type="text" name="phone"><br>
		GRADE: <input type="text" name="grade"><br>
		<input type="submit" value="전송">
	</form>
	
	<a href="/">홈으로</a>
</body>
</html>