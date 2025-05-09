<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Detail Page</h1>
	<hr>
	<form action="/modify" method="POST">
		<table>
			<thead>
				<tr>
					<th>항목</th>
					<th>입력</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="${member.id }"
						readonly></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="text" name="pw" value="${member.pw }"></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="name" value="${member.name }"></td>
				</tr>
				<tr>
					<td>PHONE</td>
					<td><input type="text" name="phone" value="${member.phone }"></td>
				</tr>
				<tr>
					<td>GRADE</td>
					<td><input type="text" name="grade" value="${member.grade }"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" style="width:50%" ><input type="button" onclick="delMember()" value="삭제" style="width:50%"></td>
				</tr>

			</tbody>
		</table>
	</form>


	<a href="/">홈으로</a>


	<script>
		function delMember() {
			const paramId = document.querySelector("input[name=id]");
			location.href = "/delete/" + paramId.value;
		}
	</script>
</body>
</html>