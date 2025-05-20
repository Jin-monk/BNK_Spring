package com.example.sessionEx01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sessionEx01.dao.IUserDao;
import com.example.sessionEx01.dto.UserDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao userDao;
	
	@GetMapping("/userList")
	public String userList(Model model) {
		
		List<UserDTO> list = userDao.getUserList();
		model.addAttribute("list", list);
		return "/user/userList";
	}
	
	@GetMapping("/searchUser")
	public String searchUser(Model model,
							UserDTO user) {
		List<UserDTO> searchList = userDao.getUserListWithParam(user);
		model.addAttribute("searchList", searchList);
		return "/user/searchList";
	}
	
	@GetMapping("/searchUser2")
	public String searchUser2(Model model,
								UserDTO user) {
		List<UserDTO> searchList2 = userDao.getUserListWithParam2(user);
		model.addAttribute("searchList2", searchList2);
		return "/user/searchList2";
	}
	
	@PostMapping("/create")
	public String insert (@Valid UserDTO user,
							BindingResult result,
							Model model) {
		if(result.hasErrors()) {
			if(result.getFieldError("id") != null) {
				System.out.println("1: " 
				+ result.getFieldError("id").getDefaultMessage());
			}
			if(result.getFieldError("pw") != null) {
				System.out.println("2: "
				+ result.getFieldError("pw").getDefaultMessage());
			}
		}
		if(result.hasErrors() == false ) {
			userDao.createUser(user);
			model.addAttribute("user", user);
			System.out.println(user);
			return "redirect:/user/joinSuccess";
		}
		return "/user/userList";
	}
	
	@GetMapping("/joinSuccess")
	public String joinSuccess () {
		return "/user/joinSuccess"; 
	}
	
	
	
	
}
