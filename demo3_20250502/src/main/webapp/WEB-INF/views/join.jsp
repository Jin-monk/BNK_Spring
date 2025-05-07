<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<hr>

	<form action="join" method="POST" name="frm" >
		ID: <input type="text" name="id" /> 
		<input type="button" value="중복체크" onclick="checkIdF()" />
		<p id="checkIdRes">---------</p>
		
		PW: <input type="text" name="pw" /><br> 
		PW CHECK: <input type="text" name="checkPw" onchange="checkPwF()" />
		<p id="checkPwRes">---------</p>
		
		NAME: <input type="text" name="name" id="nameId"/><br> 
		PHONE: <input type="text" name="phone" id="phoneId"/><br>
		<input type="submit" value="전송" />
	</form>
	<br>

	<a href="/">홈으로</a>

	<script>
		const form = document.forms["frm"];
		let isCheckId = false;
		let isCheckPw = false;
		
		//아이디 유효성검사
		function checkIdF() {
			const inputId = form.id.value.trim();
			const resEl = document.getElementById("checkIdRes");
			//아이디 공란확인
			if (inputId === "") {
				alert("ID 입력하세요.")
				form.id.focus();
				isCheckId = false;
				return;
			}

			//아이디 중복확인
			const xhr = new XMLHttpRequest();
			xhr.open("POST", "checkId", true);
			xhr.setRequestHeader("Content-type" , "application/x-www-form-urlencoded");
			xhr.send("id="+inputId);
			
			xhr.onload = function(){
				const result  = xhr.responseText;
				resEl.innerText = result ;
				
				if(result.includes("이미 사용 중인 ID입니다.")){
					isCheckId = false;
					resEl.style.color= "red";
				}else{
					isCheckId = true;
					resEl.style.color= "green";
				}
			}
		}

		function checkPwF() {
			//비밀번호 동일 확인
			const pw = form.pw.value.trim();
			const checkPw = form.checkPw.value.trim();
			const checkPwRes = document.getElementById("checkPwRes");
			console.log(checkPw);
			console.log(checkPwRes);

			if (pw === "" || checkPw === "") {
				alert("비밀번호를 입력하세요.");
				form.pw.focus();
				checkPwRes.innerText = "비밀번호를 입력하세요.";
				checkPwRes.style.color = "red";
				isCheckPw = false;
				return;
			} else if (pw !== checkPw) {
				checkPwRes.innerText = "비밀번호가 일치하지 않습니다.";
				checkPwRes.style.color = "red";
				isCheckPw = false;
				return;
			} else if (pw === checkPw) {
				checkPwRes.innerText = "비밀번호가 일치합니다.";
				checkPwRes.style.color = "green";
				isCheckPw = true;
			}
		}
		
		// submit 최종 확인
		document.getElementById("frm").addEventListener("submit",lastCheck);
		
		function lastCheck(event){
			const nameId = document.getElementById("nameId");
			const phoneId = document.getElementById("phoneId");
			
			event.preventDefault(); // submit 중지
			if(isCheckId === false || isCheckPw === false){
				return;
			}
			if(nameId.value.trim() ===""){
				alert("이름을 입력하세요.")
				return;
			}
			if(phoneId.value.trim() ===""){
				alert("휴대폰 번호를 입력하세요.")
				return;
			}
			form.submit();
		}
		
	</script>
</body>
</html>