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
import com.example.test2.dao.ICommentDao;
import com.example.test2.dao.IMemberDao;
import com.example.test2.dto.BoardDTO;
import com.example.test2.dto.CommentDTO;
import com.example.test2.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private IBoardDao boardDao;
	
	@Autowired
	private ICommentDao commentDao;
	
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
	
	@GetMapping("/pagination/{page}")
	public String pagination(@PathVariable("page")int page,
							Model model) {
		System.out.println("pagination...");
		int pageSize = 10 ; // 1개의 페이지 게시글 수 
		int blockSize = 10 ; // 페이지 번호 수 per block
		
		// 게시글 범위 계산
		int start = (page -1) * pageSize + 1 ; //시작 rn 
		int end = page * pageSize ;  // 끝 rn 
		
		// 전체 게시글 수 및 전체 페이지 수 계산
		int totalCount = boardDao.getBoardCount(); //게시글 총 갯수 
		int totalPage = (int)Math.ceil((double)totalCount / pageSize); // 총 갯수 / 1페이지 당 게시글 갯수의 올림 
		
		// 블록 계산 
		int startPage = ((page-1)/blockSize) * blockSize + 1 ; 
		int endPage = Math.min(startPage + blockSize - 1, totalPage);
		
		boolean hasPrevBlock = startPage > 1; 
		boolean hasNextBlock = endPage < totalPage;
	
		// 데이터 조회 
		List<BoardDTO> board=  boardDao.pagination(start,end);
		
		// jsp 전달
		
		model.addAttribute("board", board); // 데이터 
		model.addAttribute("currentPage", page); // 현재 페이지
		model.addAttribute("totalPage", totalPage); //총 페이지수 
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevBlock", hasPrevBlock);
		model.addAttribute("hasNextBlock", hasNextBlock);
		
	
		return "showBoard";
		
		
		
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
	
	@GetMapping("/writeBoard")
	public String writeBoard(BoardDTO board) {
		System.out.println("writeBoard...");
		boardDao.writeBoard(board);
		return "redirect:/showBoard";
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
		System.out.println("delete..........."+bno);
		MemberDTO userInfo = (MemberDTO)session.getAttribute("loginInfo");
		BoardDTO board = boardDao.getBoardByBno(bno);
		if(board.getWriter().equals(userInfo.getId())) {
			boardDao.deleteBoard(bno);
			System.out.println("게시물 삭제 완료...");
			return "redirect:/showBoard";
		}else {
			System.out.println("게시물 삭제 실패...");
			return "showBoard";
		}
		
	}
	
	@GetMapping("/writeCommnet")
	public String writeCommnet(@RequestParam("bno")String bno,
								CommentDTO comment) {
		commentDao.writeComment(bno, comment);
		System.out.println("bno: "+bno);	
		System.out.println("댓글 정보: "+ comment);
		return "index";
	}
	
	
	
	
}
