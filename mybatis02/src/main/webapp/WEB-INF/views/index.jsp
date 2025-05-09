<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<jsp:include page="fragments/header.jsp" />
	<h1>Index Page</h1>
	<hr>
	<img src="/images/강아지.jpg" alt="dog">
	<jsp:include page="fragments/footer.jsp" />
	<script>
		setTimeout(() =>{
			location.href="/p1";
		},2000);
	</script>
</body>
</html>