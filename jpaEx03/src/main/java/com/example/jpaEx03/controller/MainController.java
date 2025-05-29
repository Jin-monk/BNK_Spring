package com.example.jpaEx03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpaEx03.entity.BoardEntity;
import com.example.jpaEx03.entity.MemberEntity;
import com.example.jpaEx03.repository.BoardRepository;
import com.example.jpaEx03.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/")
	public String root() {
		return"index";
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join")
	public String join (MemberEntity member) {
		member.setRole("MEMBER");
		memberRepository.save(member);
		return "index";
	}
	@GetMapping("login")
	public String loginForm() {
		return"login";
	}
	@PostMapping("login")
	public String login(@RequestParam("id")String id,
						@RequestParam("pw")String pw,
						HttpSession session,
						Model model) {
		int result = memberRepository.countByIdAndPw(id,pw);
		if(result == 1) {
			Optional<MemberEntity> m1 = memberRepository.findById(id);
			if(m1.isPresent()) {
				MemberEntity member = m1.get();
				session.setAttribute("loginInfo", member);
			}
			return "index";
		}else {
			return "login";
		}
	}
	
	//게시글 작성
	@GetMapping("writeBoard")
	public String writeBoardForm(HttpSession session,
								Model model) {
		MemberEntity member = (MemberEntity) session.getAttribute("loginInfo");
		if (member == null) {
			return "redirect:/";
		}
		model.addAttribute("loginInfo", member);
		return "writeBoard";
	}
	
	@PostMapping("writeBoard")
	public String writeBoard(BoardEntity board) {
		boardRepository.save(board);
		return "redirect:/showBoard";
	}
	
	@GetMapping("showBoard")
	public String showBoard(Model model) {
		List<BoardEntity> bList = boardRepository.findAll();
		model.addAttribute("bList", bList);
		return "showBoardList";
	}
	
	
}
