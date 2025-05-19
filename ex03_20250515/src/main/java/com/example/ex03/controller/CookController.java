package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
public class CookController {
	
	@GetMapping("/cook/maindish")
	@ResponseBody
	public String maindish() {
		System.out.println("maindish...");
		return "메인 요리가 나옵니다.";
	}
}
