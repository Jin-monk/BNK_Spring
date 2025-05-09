package com.example.test2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test2.dao.IBoardDao;
import com.example.test2.dao.IMemberDao;
import com.example.test2.dto.BoardDTO;
import com.example.test2.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private IBoardDao boardDao;
	
	@GetMapping("/index")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/toJoin")
	public String toJoin() {
		System.out.println("toJoin...");
		return "/join";
	}
	
	@GetMapping("/toLogin")
	public String toLogin() {
		System.out.println("toLogin...");
		return "/login";
	}
	
	@PostMapping("/joinMember")
	public String joinMember(MemberDTO member) {
		memberDao.joinMember(member);
		return "index";
	}
	
	@PostMapping("/loginMember")
	public String loginMember(@RequestParam("id")String id,
							@RequestParam("pw")String pw,
							HttpServletRequest request) {
		System.out.println("login 진행중 ...");
		MemberDTO member =memberDao.loginCheck(id,pw);
		HttpSession session = request.getSession();
		if(member.getId().equals(id) && member.getPw().equals(pw) ) {
			session.setAttribute("loginInfo", member);
		}else {
			session.setAttribute("loginError", "로그인이 실패했습니다.");
		}
		
		return "redirect:/index";
	}
	
	
	@GetMapping("/toOnlyMember")
	public String tnOnlyMember() {
		System.out.println("toOnlyMember...");
		return "onlyMember";
	}
	
	@GetMapping("/showMember")
	public String showMember(Model model) {
		System.out.println("showMember...");
		List<MemberDTO> mList = memberDao.memberList();
		model.addAttribute("memberList", mList);
		return "showMember";
	}
	
	@GetMapping("/showBoard")
	public String showBoard(Model model) {
		List<BoardDTO> board = boardDao.boardList();
		model.addAttribute("board", board);
		return "showBoard";
	}
	
	@GetMapping("/toWriteBoard")
	public String toWriteBoard() {
		System.out.println("toWriteBoard...");
		return "writeBoard";
	}
	
	@GetMapping("/boardDetail")
	public String boardDatail(@RequestParam("title")String title,Model model) {
		System.out.println("boardDatail...");
		BoardDTO board = boardDao.getBorad(title);
		model.addAttribute("board", board);
		System.out.println(board);
		return "boardDetail";
	}
	
	@GetMapping("/boardUpdate")
	public String boardUpdate(BoardDTO board) {
		boardDao.boardUpdate(board);
		return "index";
	}
	
	@GetMapping("/delete/{bno}")
	public String boardDelete(@PathVariable("bno")String bno,
							HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO checkWriter = (MemberDTO)session.getAttribute("loginInfo");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		boardDao.getBoardByWriter(checkWriter.getId());
		return "";
	}
	
	
	
	
	
}
