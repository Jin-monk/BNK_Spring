package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex03.dto.UserDTO;

@Controller
@RequestMapping("/api")
public class AjaxController {

	@GetMapping("/")
	public String root() {
		return "ajax";
	}
	
	@GetMapping("/data")
	public @ResponseBody String data() {
		System.out.println("$.ajax...");
		return "<h2>성공적인 $Ajax</h2>";
	}
	
	@GetMapping("/data1")
	public @ResponseBody String data2(@RequestParam("name")String name,
									@RequestParam("age")int age) {
		System.out.println("$.ajax...");
		UserDTO user1 = new UserDTO ();
		user1.setName(name);
		user1.setAge(age);
		
		return "<h2>"+user1+"</h2>";
	}
	
	
	
	@PostMapping("/post")
	public @ResponseBody String post(@RequestBody UserDTO user) {
		String name = user.getName();
		int age = user.getAge();
		return "<h2>이름: "+name+", 나이: "+age+"</h2>";
	}
}
