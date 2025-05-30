package com.example.jpaEx04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpaEx04.dto.UserDTO;
import com.example.jpaEx04.entity.User;
import com.example.jpaEx04.service.JoinService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	private JoinService joinService;
	
	@GetMapping("/")
	public String root () {
		return "index";
	}
	
	@GetMapping("registMember")
	public String regForm() {
		return "registForm";
	}
	
	@PostMapping("/regist")
	public @ResponseBody String registMember(UserDTO user) {
		log.info("user: "+user);
		// 파라미터 서비스에 전달 -> 서비스에서 회원가입 처리를 할 것임.
		User result = joinService.regist(user);
		if(result != null) {
			return "회원가입 완료";
		}else {
			return "회원가입 실패";
		}
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@GetMapping("/fail")
	public String fail() {
		return "fail"; 
	}
	
	@PostMapping("/loginProc")
	public String loginProc() {
		
		return ""; 
	}
	
	
	
	
}
