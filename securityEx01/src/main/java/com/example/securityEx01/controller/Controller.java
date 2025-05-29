package com.example.securityEx01.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("msg", "Security ~");
		return "index";
	}
	
	@GetMapping("/p1")
	public String p1 () {
		return "p1";
	}
	
	@GetMapping("/login")
	public String login () {
		return"login";
		
	}
}
