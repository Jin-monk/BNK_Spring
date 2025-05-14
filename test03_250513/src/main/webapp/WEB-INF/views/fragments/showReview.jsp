<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Review Page</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.review-form {
	margin-top: 30px;
	padding: 15px;
	border: 1px solid #ddd;
	background-color: #f9f9f9;
}

.review-form input[type="text"], .review-form textarea {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.review-form input[type="submit"] {
	padding: 8px 16px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h1>리뷰 목록</h1>
	<hr>

	<table>
		<thead>
			<tr>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="r" items="${reviewList}">
				<tr>
					<td>${r.writerId}</td>
					<td>${r.revContent}</td>
					<td>${r.revDate}
									<c:if test="${loginInfo.id == r.writerId}">
										<form action="/deleteReview/${r.reviewNo}/${movNo}" method="post"
												style="display: inline;">
												<input type="submit" value="삭제">
										</form>
									</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- 리뷰 작성 폼 -->
	<div class="review-form">
		<h3>리뷰 작성</h3>
		<form action="/writeReview" method="post">
			<input type="hidden" name="movNo" value="${movNo}"> <input
				type="hidden" name="writerId" value="${loginInfo.id}"> 내용:<br>
			<textarea name="revContent" rows="4" required></textarea>
			<br> <input type="submit" value="작성하기">
		</form>
	</div>

	<a href="/">홈으로</a>
	<script>
		console.log("{r.reviewNo}");
	</script>
</body>
</html>
