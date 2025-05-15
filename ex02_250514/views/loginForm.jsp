<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form Page</h1>
	<hr>
	<c:if test="${loginFail}">
		<script>
			alert("ID 혹은 PW를 다시 잘못되었습니다.");
		</script>
	</c:if>
	
	<c:if test="${notUser}">
		<script>
			alert("회원 전용 페이지입니다.");
		</script>
	</c:if>
	
	<c:if test="${autoLogout}">
		<script>
			alert("시간 경과로 자동 로그아웃 되었습니다.");
		</script>
	</c:if>
	
	
	
	<form action="login" method="POST">
		ID: <input type="text" name="id"><br>
		PW: <input type="text" name="pw"><br>
		<input type="submit" value="가입"><br>
	</form>
</body> 
</html>