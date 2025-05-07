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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired // 인스턴스 자동 연결
	private MemberDAO memberDao;

	@Autowired
	private MemberService memberService;

	@RequestMapping("/")
	public String root() {
		System.out.println("root..........");
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		System.out.println("home");
		return "index";
	}

	@GetMapping("/toJoin")
	public String toJoin() {
		System.out.println("toJoin...");

		return "join";
	}
	
	@GetMapping("toLogin")
	public String toLogin() {
		System.out.println("toLogin....");
		return "login";
	}
	
	@PostMapping("checkId")
	@ResponseBody
	public String checkId(@RequestParam("id")String id) {
		System.out.println("checkId.....");
		boolean inDuplicate = memberDao.selectOnlyId(id);
		
		return inDuplicate ? "이미 사용 중인 ID입니다. ":"사용 가능한 ID 입니다.";
	}
	
	//로그인 시 id, pw 올바른지 확인 
	@PostMapping("login")
	public String login(@RequestParam("id")String id,
						@RequestParam("pw")String pw,
						HttpSession session,
						Model model) {
		System.out.println("login......");
		
		if(memberService.checkIdPw(id,pw)) {
			session.setAttribute("login", id);
			return "redirect:/home";
		}else {
			model.addAttribute("loginError", "로그인 실패");
			return "login";
		}
		
	}
	
	//회원가입 id, pw  service 연결 
	@PostMapping("/join")
	public String join(@RequestParam("pw") String pw,
			@RequestParam("checkPw") String checkPw,
			MemberDTO member,
			Model model) {
		System.out.println("join....");
		
		int insertRes = memberService.joinService(member); // id 중복확인
		boolean checkPwRes = memberService.checkPw(pw, checkPw); //pw 동일확인
		
		if (checkPwRes==true && insertRes==1) { //id, pw 검사 
			return "index"; // 문제없음.
		} else {
			// jsp 에서 구현 필요 . 
//			model.addAttribute("joinError", "회원가입 실패");
			return "join"; // 문제있음.
		}
	}

	// 수정 사전작업
	@GetMapping("/beforeupdate")
	public String beforeupdate(@RequestParam("id") String id, Model model) {
		System.out.println("beforeupdate.....");
		MemberDTO member = memberDao.viewMember(id);
		model.addAttribute("member", member);
		return "updateinfo";
	}

	// 수정
	@PostMapping("/updateinfo")
	public String updateinfo(MemberDTO member) {
		System.out.println("updateinfo....");
		memberDao.update(member);
		return "index";
	}

	// 삽입
	@PostMapping("/write")
	public String write(MemberDTO member) {
		System.out.println("write.........");

		// 서비스 호출 필요
		memberDao.insert(member);
		System.out.println("성공!");
		return "index";
	}

	// 전체조회
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("list..........");
		List<MemberDTO> list = new ArrayList<>();
		list = memberDao.list();

		model.addAttribute("list", list);

		return "list";
	}

	// 1개 조회
	@GetMapping("/datail")
	public String list(@RequestParam("id") String id, Model model) {
		MemberDTO member = memberDao.viewMember(id);

		model.addAttribute("member", member);

		return "datail";
	}
	
}
