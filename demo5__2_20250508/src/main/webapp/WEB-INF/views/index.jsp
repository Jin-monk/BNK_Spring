
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> index page </h1>
	<hr>
	<button onlick="">data</button>
	<script>
		const xhr = new XMLHttpRequest();
		xhr.open();
		xhr.onload = function (){
			xhr.responseText;
		}
		xhr.send();
	</script>
</body>
</html>