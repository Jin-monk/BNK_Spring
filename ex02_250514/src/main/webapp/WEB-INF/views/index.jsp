<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<button onclick="run()">실행 (GET)</button>
	<div id="demo">----</div>
	
	<button onclick="run1()">실행 (GET)</button>
	<div id="demo1">----</div>
	
	<button onclick="run2()">실행 (POST - JSON)</button>
	<div id="demo2">----</div>
	
	<button onclick="run3()">실행 (POST - Form)</button>
	<div id="demo3">----</div>
	
	
	<script>
	
		function run(){ 
			// GET 방식 요청
			axios.get('/api/user/1')
			.then(response => {
				console.log(response.data);
				document.getElementById("demo").innerHTML = response.data.id +", "+response.data.name ;	
			})
			.catch(error => {
				document.getElementById("demo").innerHTML = error; 
			});
			
			
		}
		
		function run1(){ 
			// GET 방식 요청
			axios.get('/api/user',{
				params: {
					id: 'hong',
					name: 'Hong gil dong'
				}
			})
			.then(response => {
				console.log(response.data);
				document.getElementById("demo1").innerHTML = response.data.id +", "+response.data.name ;	
			})
			.catch(error => {
				document.getElementById("demo1").innerHTML = error; 
			});
			
			
		}	
		
		function run2(){ 
			// POST 방식 요청
			axios.post('/api/user2',{
				name: 'james dean',
				id: 'JD'
			})
			
			.then(response => {
				console.log(response.data);
				document.getElementById("demo2").innerHTML = response.data.id +", "+response.data.name ;	
			})
			.catch(error => {
				document.getElementById("demo2").innerHTML = error; 
			});
			
			
		}
		
		function run3(){ 
			// POST 방식 요청
			const formData = new FormData();
			formData.append('id','ddd');
			formData.append('name','Dennis');
			
			axios.post('/api/user3',formData,{
				header: {
					'Content-Type':'multipart/form-data'
				}
			})
			.then(response => {
				console.log('POST(Form) 성공: ' + response.data.id +","+ response.data.name);
			})
			.catch(error =>{
				console.log('POST(Form) 실패: ' + error);
			})
			
		}
		
	</script>
</body>
</html>