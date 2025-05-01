package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String f() {
		System.out.println("f함수 ");
		return "Springboot Start";
	}
	
	@GetMapping("/p2")
	public String p2(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("name") String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		
		return "p2";
	}
}
