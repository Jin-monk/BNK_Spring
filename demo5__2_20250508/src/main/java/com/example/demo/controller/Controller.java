package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ApiService;

@Controller
public class Controller {

	@Autowired
	private ApiService apiService;

	@RequestMapping("/")
	public String root() {
		System.out.println("root..");
		return "index";
	}


	@GetMapping("/cultural")
	public String data2() {

		return "";
	}


}
