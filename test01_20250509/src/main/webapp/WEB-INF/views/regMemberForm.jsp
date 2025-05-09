<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Regist Member Form</h1>
	<hr>
	<form action="/regist" method="POST">
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>입력</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>ID </td>
				<td><input type="text" name="id"></td>
			</tr>		
			<tr>
				<td>PW </td>
				<td><input type="text" name="pw"></td>
			</tr>		
			<tr>
				<td>NAME </td>
				<td><input type="text" name="name"></td>
			</tr>		
			<tr>
				<td>PHONE </td>
				<td><input type="text" name="phone"></td>
			</tr>		
			<tr>
				<td>GRADE </td>
				<td><input type="text" name="grade"></td>
			</tr>		
			<tr >
				<td colspan="2"><input type="submit" value="가입" style="width: 100%"></td>
			</tr>
		
		</tbody>
	</table>
	</form>
	<a href="/">홈으로</a>
</body>
</html>