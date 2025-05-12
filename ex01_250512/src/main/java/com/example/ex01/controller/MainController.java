package com.example.ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ex01.dao.IMemberDAO;
import com.example.ex01.dto.MemberDTO;

@Controller
public class MainController {

	@Autowired
	private IMemberDAO memberDao;
	
	@GetMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
}
