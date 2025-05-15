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
<jsp:include page="fragments/header.jsp"></jsp:include>
	<h2>Login Page</h2>
	<hr>
	
	<c:if test="${not empty needLogin }">
		<script>
			alert("로그인이 필요합니다.");
		</script>
	</c:if>
	
	<form action="/login" method="POST">
		ID:<input type="text" name="id"><br>
		PW:<input type="password" name="pw">
		<input type="submit" value="로그인">
	</form>
</body>
</html>