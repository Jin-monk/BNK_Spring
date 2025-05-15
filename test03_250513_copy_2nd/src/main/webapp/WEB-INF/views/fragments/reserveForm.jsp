<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>영화 예매</title>
	<style>
		form {
			max-width: 400px;
			margin: 30px auto;
			padding: 20px;
			border: 1px solid #ccc;
			border-radius: 8px;
			background-color: #f9f9f9;
		}
		label {
			display: block;
			margin-top: 10px;
			font-weight: bold;
		}
		input[type="date"],
		input[type="number"],
		input[type="submit"] {
			width: 100%;
			padding: 8px;
			margin-top: 5px;
			box-sizing: border-box;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="/successReserve" method="GET" name="frm">
		<h3>영화 예매</h3>

		<label for="watchDate">상영날짜</label>
		<input type="date" name="watchDate" id="watchDate" required>

		<label for="seatCount">인원수</label>
		<input type="number" name="seatCount" id="seatCount" min="1" max="4" required>

		<input type="hidden" name="resId" value="${loginInfo.id}">
		<input type="hidden" name="movTitle" value="${movTitle}">
		<input type="hidden" name="movNo" value="${movNo}">

		<input type="submit" value="예매">
	</form>

</body>
</html>
