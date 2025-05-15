package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.net.httpserver.Request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	@GetMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@GetMapping("/sessionTest")
	public String sessionTest(HttpServletRequest request,
								RedirectAttributes rttr){
		System.out.println("sessionTest...");
		HttpSession session = request.getSession();
		String userInfo = (String)session.getAttribute("loginInfo");
		System.out.println("user: "+ userInfo);
		if(userInfo == null) {
			rttr.addFlashAttribute("notUser", true);
			return "redirect:/login";
			
		}else {
			return"sessionTest";
			
		}
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login...");
		return "loginForm";
		
	}
	
	@PostMapping("/login")
	public String postLogin(@RequestParam("id")String id,
							@RequestParam("pw")String pw,
							HttpServletRequest request,
							RedirectAttributes rttr) {
		System.out.println("postLogin...");
		if(id.equals("aaa") && pw.equals("1234")) {
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", id);
			return "redirect:/sessionTest" ; 
		}else {
			System.out.println("로그인 실패");
			rttr.addFlashAttribute("loginFail", true);
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/remove")
	public String remove(HttpServletRequest request,
						RedirectAttributes rttr) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		rttr.addFlashAttribute("autoLogout", true);
		return "redirect:/login";
		
	}
	
	@GetMapping("/logout")
	public String logout (HttpServletRequest request) {
		System.out.println("logout...");
//		HttpSession session = request.getSession();
//		session.removeAttribute("loginInfo");
		request.getSession().invalidate();
		
		return "redirect:/login";
	}
	
	@PostMapping("/extend-session")
	public void extendSession(HttpSession session) {
		session.setMaxInactiveInterval(60);
	}
	
}
