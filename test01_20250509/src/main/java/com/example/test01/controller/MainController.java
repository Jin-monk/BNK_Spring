package com.example.test01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test01.dao.IMemberDao;
import com.example.test01.dto.MemberDTO;

import oracle.jdbc.proxy.annotation.Post;

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
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberDTO> list = memberDao.getList();
		model.addAttribute("list", list);

		return "memberList";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id")String id, Model model) {
		
		MemberDTO member= memberDao.getMember(id);
		model.addAttribute("member", member);
		return "detail";
	}
	
	@PostMapping("/modify")
	public String modify(MemberDTO member) {
		System.out.println("modify param: "+member);
		memberDao.update(member);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")String id) {
		memberDao.delete(id);
		return "redirect:/list";
	}
	
	@GetMapping("regMemberForm")
	public String regMemberForm() {
		return "regMemberForm";
	}
	
	@PostMapping("/regist")
	public String regist(MemberDTO member) {
		memberDao.insert(member);
		return "redirect:/list";
	}
	
	
}
