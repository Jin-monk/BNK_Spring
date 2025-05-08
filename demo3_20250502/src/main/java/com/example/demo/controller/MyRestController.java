package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.MemberDTO;

@RestController
public class MyRestController {

	@Autowired
	private MemberDAO memberDao;

	@GetMapping("loginAjax")
	public String loginAjax() {
		System.out.println("loginAjax...");

		return "<h1>Login Page</h1><hr><form action=\"login\" method=\"POST\">"
				+ "ID: <input type=\"text\" name=\"id\" /> PW: <input type=\"password\" name=\"pw\" /> <input type=\"submit\" value=\"로그인 \" /></form>";

	}

	@GetMapping("joinForm")
	public String joinForm() {
		System.out.println("joinForm...");
		return """
							<h1>Join Page</h1>
				<hr>
				<form action="join" method="POST" name="frm" id="frm">
					ID: <input type="text" name="id" onchange="checkIdF()" />
					<input type="button" value="중복체크" onclick="checkIdF()" />
					<p id="checkIdRes">---------</p>

					PW: <input type="text" name="pw" /><br>
					PW CHECK: <input type="text" name="checkPw" onchange="checkPwF()" />
					<p id="checkPwRes">---------</p>

					NAME: <input type="text" name="name" id="nameId"/><br>
					PHONE: <input type="text" name="phone" id="phoneId"/><br>
					<input type="submit" value="전송" />
				</form>
							""";
	}

	@GetMapping("loginForm")
	public String loginForm() {
		System.out.println("loginForm...");
		return """
						<h1>Login Page</h1>
				<hr>

				<form action="login" method="POST">
					ID: <input type="text" name="id" >
					PW: <input type="password" name="pw" >
					<input type="submit" value="로그인" >
				</form>
							""";
	}

	@GetMapping("showMemberList")
	public List<MemberDTO> showMemberList() {
		System.out.println("showMemberList...");
		return memberDao.list();
	}

	@GetMapping("listAjax")
	public String qwer(Model model) {
		System.out.println("listAjax...");
		List<MemberDTO> list = new ArrayList<>();
		list = memberDao.list();

		model.addAttribute("list", list);
		return """
							<h1>List Page</h1>
				<hr>
				<table border="1">
					<thead>
						<tr>
							<th>no</th>
							<th>id</th>
							<th>pw</th>
							<th>name</th>
							<th>phone</th>
							<th>grade</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${list }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td><a href="datail?id=${member.id}"> ${member.id}</a></td>
							<td>${member.pw}</td>
							<td>${member.name}</td>
							<td>${member.phone}</td>
							<td>${member.grade}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
							""";
	}

}
