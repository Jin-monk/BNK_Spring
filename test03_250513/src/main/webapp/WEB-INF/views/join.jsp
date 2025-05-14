<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
	<h2>Join Page</h2>
	<hr>
	
	<form action="join" method="POST" name="frm">
		ID: <input type="text" name="id">
		<button type="button" onclick="duplicateCheckId()">중복체크</button>
		<p id="checkIdRes">--</p>
		PW: <input type="text" name="pw"><br>
		CHECK PW: <input type="text" name="checkPw" onblur="doubleCheckPw()"><br>
		<p id="checkPwRes">--</p>
		NAME: <input type="text" name="name"><br>
		PHONE: <input type="text" name="phone" value="010-0000-0000"><br>
		<input type="submit" value="회원가입"><br>
	</form>

	<script>
		const form = document.forms["frm"];
		let isCheckId = false;
		let isCheckPw = false;
		const checkIdRes = document.getElementById("checkIdRes");
		const checkPwRes = document.getElementById("checkPwRes");
		
		function duplicateCheckId(){
			
			const inputId = form.id.value.trim();
			if(inputId ===''){
				alert("ID를 입력하세요.")
				form.id.focus();
				isCheckId = false;
				return;
			}
			const idRegex = /^[A-Za-z][A-Za-z0-9]{7,}$/;
			if (!idRegex.test(inputId)){
				alert("ID는 영문으로 시작하고 8자 이상이어야 하며, 숫자 또는 영문만 포함할 수 있습니다.");
				form.id.focus();
				isCheckId = false;
				return;
			}
			
			const xhr = new XMLHttpRequest();
			xhr.open("POST","dupCheckId");
			xhr.setRequestHeader("Content-type" , "application/x-www-form-urlencoded");
			xhr.onload = function(){
				let result = xhr.responseText;
				console.log(result);
				console.log(typeof(result));
				
				if (result === '1' ){
					checkIdRes.innerText = "사용이 불가한 ID입니다.";
					checkIdRes.style.color = "red";
					isCheckId = false;
					return;
				}else if(result === '0' ){
					checkIdRes.innerText = "사용이 가능한 ID입니다.";
					checkIdRes.style.color = "green";
					isCheckId = true;
				}
			}
			xhr.send("id="+inputId);
			
		}
		
		function doubleCheckPw(){
			const inputPw = form.pw.value.trim();
			const inputCheckPw = form.checkPw.value.trim();
			console.log(inputPw);
			console.log(inputCheckPw);
			
			if(inputPw ===''){
				alert('비밀번호를 입력하세요.')
				form.pw.focus();
				isCheckPw = false;
				return;
			}
			if(inputCheckPw ===''){
				alert('비밀번호를 입력하세요.')
				form.checkPw.focus();
				isCheckPw = false;
				return;
			}
			if(inputPw === inputCheckPw){
			const pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
				if(!pwRegex.test(inputPw)){
					alert("비밀번호는 영문, 숫자, 기호를 포함한 8자 이상이여야 합니다.");
					checkPwRes.innerText = "사용할 수 없는 비밀번호입니다.";
					checkPwRes.style.color = "red";
					isCheckPw = false;
					return; 
				}else{
					checkPwRes.innerText = "사용 가능한 비밀번호입니다.";
					checkPwRes.style.color = "green";
					isCheckPw = true;
				}
			}else{
				checkPwRes.innerText = "입력한 비밀번호가 다릅니다.";
				checkPwRes.style.color = "red";
				isCheckPw = false;
				return;
			}
		}
		form.addEventListener("submit",finalCheck);
		function finalCheck(event){
			if(!(isCheckId && isCheckPw)){
				event.preventDefault();
				alert("정보를 다시 한번 확인하세요.");
			}
			
		}
		
	
		
		
	</script>	
</body>
</html>