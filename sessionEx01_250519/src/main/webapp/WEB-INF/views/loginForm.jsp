<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form Page</h1>
	<hr>
	<div>${msg }</div>
	<form action="login" method="post">
		ID: <input type="text" name="id" value="aaa">
		PW: <input type="text" name="pw" value="1234">
		<input type="submit" value="가입">
	</form>
</body>
</html>