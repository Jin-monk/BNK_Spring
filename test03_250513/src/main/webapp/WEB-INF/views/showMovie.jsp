<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Movie Page</title>
	<style>
		table {
			border-collapse: collapse;
			width: 100%;
			margin-bottom: 20px;
		}
		th, td {
			border: 1px solid #999;
			padding: 10px;
		}
	</style>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
	<h2>Show Movie Page</h2><br>
	<button type="button" onclick="" >개봉예정영화</button>
	<button type="button" onclick="" >현재상영영화</button>
	<hr>
	
	<table>
		<thead>
			<tr>
				<th>포스터</th>
				<th>제목</th>
				<th>내용</th>
				<th>개봉일</th>
				<th>종료일</th>
				<th>감독</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${movList}">
				<tr>
					<td>
						<a href="/movieDetail/${m.movNo}">
							<img src="${m.posterUrl}" alt="${m.movTitle}" width="100">
						</a>							
					</td>
					<td>${m.movTitle}</td>
					<td>${m.movContent}</td>
					<td>${m.openDate}</td>
					<td>${m.endDate}</td>
					<td>${m.supervision}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${errorDate}">
		<script>
			alert("예약 날짜가 잘못되었습니다.");
		</script>
	</c:if>
</body>
</html>
