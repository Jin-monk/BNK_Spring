<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<hr>
	
	<form action="login" method="POST">
		ID: <input type="text" name="id" >
		PW: <input type="password" name="pw" >
		<input type="submit" value="로그인" >
	</form>
	<a href="/">홈으로</a>
</body>
</html>