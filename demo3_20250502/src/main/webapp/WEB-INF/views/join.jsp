<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Join Page </h1>
	<hr>
	
	<form action="write" method="POST" name="form">
		ID: <input type="text" name="id"><br>
		PW: <input type="text" name="pw"><br>
		NAME: <input type="text" name="name"><br>
		PHONE: <input type="text" name="phone"><br>
		GRADE: <input type="text" name="grade"><br>
		<input type="submit" value="전송">
	</form>
	
	<a href="/">홈으로</a>
	
	<script>
		const inputId = form.id.trim().value;
		
	</script>
</body>
</html>