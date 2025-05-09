package com.example.mybatis02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mybatis02.dao.IMemberDao;

@Controller
public class MainController {

	private IMemberDao memberDao;
	
	
	@Autowired
	public MainController(IMemberDao dao) {
		memberDao = dao;
	}
	
	@GetMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/p1")
	public String p1() {
		return "p1";
	}
	
	@GetMapping("/p2")
	public String p2() {
		return "p2";
	}
	
}
