package com.example.test03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test03.dao.IMemberDAO;
import com.example.test03.dao.IMovReviewDAO;
import com.example.test03.dto.MemberDTO;
import com.example.test03.dto.MovReviewDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class MyRestController {

	@Autowired
	private IMemberDAO memberDao;
	
	@Autowired
	private IMovReviewDAO movReviewDao;
	
	//아이디 중복확인 후 0 또는 1 반환
	@PostMapping("/dupCheckId")
	public int join(MemberDTO member) {
		System.out.println("join...");
		MemberDTO m1 = memberDao.getIdById(member.getId());
		if(m1 != null) {
			return 1 ;
		}else {
			return 0 ;
		}
	}
	
//		//movieDetail.jsp 에서 리뷰 데이터 가져오기
//		@GetMapping("/getReview/{movNo}")
//		public List<MovReviewDTO> getReview(@PathVariable("movNo")int movNo) {
//			List<MovReviewDTO> reviewList = movReviewDao.getReview(movNo);
//			System.out.println("reviewList...");
//			return reviewList;
//			
//		}
		
		/*
		 * //영화 예약 form
		 * 
		 * @GetMapping("/reserveMovie/{movNo}") public String
		 * reserveMovie(@PathVariable("movNo")int movNo, HttpServletRequest request,
		 * Model model) { System.out.println("reserveMovie..."); HttpSession session =
		 * request.getSession(); MemberDTO loginInfo =
		 * (MemberDTO)session.getAttribute("loginInfo"); if(loginInfo == null) { return
		 * "redirect:/toLogin"; }else {
		 * 
		 * return """ <form action="/successReserve" method="GET" name="frm"> 상영날짜:
		 * <input type="date" name="watchDate"> 인원수: <input type="number"
		 * name="seatCount" min="1" max="4"> <input type="submit" value="예매"> </form>
		 * <script> const form = document.forms["frm"];
		 * 
		 * </script>
		 * 
		 * """; } }
		 */
	
}
	