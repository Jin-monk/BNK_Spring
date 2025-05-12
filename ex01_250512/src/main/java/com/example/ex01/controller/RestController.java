package com.example.ex01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ex01.dao.IMemberDAO;
import com.example.ex01.dto.MemberDTO;

@CrossOrigin(origins = "*")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private IMemberDAO memberDao;	
	
	
	
	@GetMapping("/member")
	public MemberDTO member() {
		System.out.println("member...");
		MemberDTO m1 = memberDao.getMember();
		return m1;
	}
	
	@GetMapping("/members")
	public List<MemberDTO> members() {
		System.out.println("members...");
		List<MemberDTO> mList = memberDao.getMemberAll();
		return mList;
	}
	
	
	@PostMapping("/member")
	public int postmember(MemberDTO member) {
		System.out.println("member...");
		if(member != null) {
			System.out.println(member);
			return 1; 
		}
		return 0 ; 
	}
	
	@PostMapping("/member2")
	public int postmember2(@RequestBody MemberDTO member) {
		System.out.println("member2...");
		if(member != null) {
			System.out.println(member);
			return 1; 
		}
		return 0 ; 
	}
	
	@GetMapping("/getMember")
	public MemberDTO getMember() {
		MemberDTO m1 = memberDao.getMember();
		return m1 ; 
	}
	@PostMapping("/getMember")
	public MemberDTO getMember2() {
		MemberDTO m1 = memberDao.getMember();
		return m1 ; 
	}
	
	
	
}
