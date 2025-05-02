package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired  // 인스턴스 자동 연결 
	private MemberDAO memberDao;
	
	@RequestMapping("/")
	public String root() {
		System.out.println("root..........");
		return "index";
	}
	
	
	
	//수정 사전작업
	@GetMapping("/beforeupdate")
	public String beforeupdate(@RequestParam("id")String id, Model model) {
		System.out.println("beforeupdate.....");
		MemberDTO member= memberDao.viewMember(id);
		model.addAttribute("member", member);
		return "updateinfo";
	}
	
	//수정 
	@PostMapping("/updateinfo")
	public String updateinfo(MemberDTO member) {
		System.out.println("updateinfo....");
		memberDao.update(member);
		return "index";
	}
	
	
	//삽입
	@PostMapping("/write")
	public String write(MemberDTO member) {
		System.out.println("write.........");
		memberDao.insert(member);
		System.out.println("성공!");
		return "index";
	}
	
	//전체조회
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list..........");
		List<MemberDTO> list = new ArrayList<>();
		list =  memberDao.list();
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	//1개 조회
	@GetMapping("/datail")
	public String list(@RequestParam("id")String id ,Model model) {
		MemberDTO member = memberDao.viewMember(id);
		
		model.addAttribute("member",member);
		
		return "datail";
	}
	
}
