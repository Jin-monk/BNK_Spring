package com.example.sessionEx01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sessionEx01.dto.UserDTO;
import com.example.sessionEx01.service.UserService;
import com.example.sessionEx01.session.UserSession;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSession userSession;
	
	@GetMapping("/")
	public String root() {
		System.out.println("root..");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	//-----------------------------------------------------
	//사용자 정의 Session
	@PostMapping("/login")
	public String login2(@RequestParam("id")String id,
			 				@RequestParam("pw")String pw,
			 				RedirectAttributes rttr,
			 				HttpServletRequest request,
			 				HttpServletResponse response) {
		UserDTO result = userService.loginCheck(id,pw);
		if(result != null) {
			userSession.login(result);
			
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			
			Cookie userId = new Cookie("userId",result.getId());
			Cookie userPw = new Cookie("userPw",result.getPw());
			userId.setPath("/");
			userPw.setPath("/");
			response.addCookie(userId);
			response.addCookie(userPw);
			
			return "redirect:/success";
		}else {
			rttr.addFlashAttribute("msg", "ID와 PW를 확인하세요.");
			return "redirect:/login";
		}
		
	}

	@GetMapping("/auto-login")
	public String auto_login(HttpServletRequest request,
							HttpServletResponse response,
							Model model,
							RedirectAttributes rttr) {
		String idFromCookie = null;
		String pwFromCookie = null;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for ( Cookie cookie: cookies) {
				if(cookie.getName().equals("userId")) {
					idFromCookie = cookie.getValue();
				}else if (cookie.getName().equals("userPw")) {
					pwFromCookie = cookie.getValue();
					System.out.println(idFromCookie+pwFromCookie);
				}
			}
			
		}
		if(idFromCookie != null && pwFromCookie != null) {
			UserDTO user = userService.loginCheck(idFromCookie, pwFromCookie);
			if ( user != null) {
				model.addAttribute("userInfo", user);
				return "redirect:/success";
			}
		}
		
		rttr.addFlashAttribute("msg", "자동로그인이 실패했습니다.");
		return "redirect:/login";
	}
	
	
	@GetMapping("/success")
	public String success (RedirectAttributes rttr,
							Model model) {
		if(userSession.isLoggedIn()) {
			model.addAttribute("user", userSession.getLoginUser());
			return "loginSuccess";
		}else {
			rttr.addFlashAttribute("msg", "로그인 된 사용자만 이용 가능합니다.");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(RedirectAttributes rttr) {
		userSession.logout();
		rttr.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/login";
	}
	
	//-----------------------------------------------------
	// 쿠키 설정 및 읽기 
	
	
	@GetMapping("/set-cookie")
	public @ResponseBody String setCookie(HttpServletResponse response) {
			Cookie cookie = new Cookie("myCookie","sogood");
			cookie.setPath("/");
			response.addCookie(cookie);
		return "cookie set";
	}
	@GetMapping("/read-cookie")
	public @ResponseBody String readCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies ) {
				if(cookie.getName().equals("myCookie")) {
					System.out.println(cookie.getValue());
					
				}
			}
		}
		return "cookie read";
	}
	
	@GetMapping("/cookieMain")
	public String cookieMain() {
		return "cookieMain";
	}
	
	@GetMapping("/cookieResult")
	public String cookieResult() {
		return "cookieResult";
	}
	
	//-----------------------------------------------------
	// 팝업창 쿠키
	@GetMapping("/popupMain")
	public String popupMain() {
		return "popupMain";
	}
	
	@GetMapping("/popupCookie")
	public @ResponseBody String popupCookie(HttpServletResponse response,
											HttpServletRequest request,
											Model model) {
		String chkVal = request.getParameter("inactiveToday");
//		System.out.println("popupCookie: "+chkVal);
		if(chkVal != null && chkVal.equals("1")) {
			Cookie cookie = new Cookie("PopupClose","off");
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		
		//jsp 에서 코드를 controller로 옮기는 중 ...  수정 필요  
		String popupMode = "on";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				if(cookieName.equals(cookieName)) {
					popupMode = cookieValue; 
				}
			}
		}
		model.addAttribute("popupMode", popupMode);
		return "쿠키: 하루 동안 열지 않음";
		
	}
	
	
	
	
}
