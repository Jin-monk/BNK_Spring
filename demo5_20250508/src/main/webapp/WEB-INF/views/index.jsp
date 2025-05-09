<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index page</h1>
	<hr>
	<button onclick="getData">getData</button>
	<div id="showData"></div>
	<script>
		function getData() {
			var xhr = new XMLHttpRequest();
			var url = 'http://apis.data.go.kr/6480000/gyeongnamcultural/gyeongnamculturallist'; /*URL*/
			var queryParams = '?'
					+ encodeURIComponent('serviceKey')
					+ '='
					+ 'hWpfddmkipSxwQPRdhh%2BYe3HQ3FfJ%2FrnAEC%2FriRlcKsWXhZJHYBCWNzfQln7R8WgJrwjeT1d2dMQyObi%2BLPPqA%3D%3D'; /*Service Key*/
			queryParams += '&' + encodeURIComponent('pageNo') + '='
					+ encodeURIComponent('1'); /**/
			queryParams += '&' + encodeURIComponent('numOfRows') + '='
					+ encodeURIComponent('10'); /**/
			queryParams += '&' + encodeURIComponent('resultType') + '='
					+ encodeURIComponent('json'); /**/
			xhr.open('GET', url + queryParams);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					alert('Status: ' + this.status + 'nHeaders: '
							+ JSON.stringify(this.getAllResponseHeaders())
							+ 'nBody: ' + this.responseText);
					const data = this.responseText;
					console.log(this.responseText);
					document.getElementById("showData").innerHTML = this.responseText;
					
				}
			};

			xhr.send('');
		}
	</script>

</body>
</html>