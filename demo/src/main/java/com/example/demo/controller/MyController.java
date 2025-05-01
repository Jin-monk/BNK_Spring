package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.Member;

@Controller
public class MyController {

	
	@RequestMapping("/")
	public @ResponseBody String root() {
		System.out.println("root..........");
		return "Springboot Start!"; // return - jsp 파일이름 
	}
	
	@GetMapping("/test")
	public String test() {
		System.out.println("test..........");
		return "test";
	}
	
	@GetMapping("/p1")
	public String p1(@RequestParam("name") String name, Model model) {
//		String name = request.getParameter("name");
//		request.setAttribute("name", name);
		
		model.addAttribute("name",name);
		model.addAttribute("age",23);
		return "p1";
	}
	
	List<Member> list = new ArrayList<>();
	@PostMapping("/p2")
	public String member(Member member, Model model) {
		System.out.println("p2..........");
		list.add(member);
		
		model.addAttribute("list", list);
		
		return "p2";
	}
	
	@GetMapping("/p3/{id}/{pw}")
	public String p3(@PathVariable("id")String id,
					 @PathVariable("pw")String pw,
					 Model model) {
		System.out.println("p3.........."+id+ ", "+pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "p3";
	}
	
	
//	@PostMapping("/p2")
//	public String member(@RequestParam("id")String id,
//						@RequestParam("pw")String pw,
//						@RequestParam("name")String name,
//						Model model) {
//		List<Member> mList = new ArrayList<>();
//		Member member = new Member();
//		member.setId(id);
//		member.setPw(pw);
//		member.setName(name);
//		
//		mList.add(member);
//		
//		model.addAttribute("member", mList);
//		return "p2";
//	}
	
	
}
