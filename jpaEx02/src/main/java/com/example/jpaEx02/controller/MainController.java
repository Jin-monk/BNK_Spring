package com.example.jpaEx02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpaEx02.entity.MemberEntity;
import com.example.jpaEx02.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "regist";
	}
	
	@PostMapping("/regist")
	public String regist(MemberEntity memberEntity) {
		memberEntity.setRole("MEMBER");
		memberRepository.save(memberEntity);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberEntity> list =memberRepository.findAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("detail")
	public String detail(@RequestParam("name")String name,
						Model model) {
		MemberEntity m1 = memberRepository.findByName(name);
		model.addAttribute("member", m1);
		return "detail";
	}
	
	@GetMapping("delete")
	public String delete (@RequestParam("id")String id) {
		memberRepository.deleteById(id);
		return "redirect:/list";
	}
	
	@GetMapping("update")
	public String updateForm() {
		return "update";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(@RequestParam("id")String id,
						@RequestParam("pw")String pw) {
		int result = memberRepository.countByIdAndPw(id,pw);
		if (result == 0 ) {
			return "index";
		}else {
			return "loginSuccess";
		}
	}
	
	
	
}
