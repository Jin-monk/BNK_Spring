package com.example.ex02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex02.dto.UserDTO;

@RestController
@RequestMapping("/api") 
public class MyRestController {
	
	
	
	@GetMapping("/")
	public String root() {
		
		return "API test...";
	}
	
	@GetMapping("/user/{idx}")
	public UserDTO uesrInfo(@PathVariable("idx")int idx) {
		List<UserDTO> userList = new ArrayList<>();	
		UserDTO u1 = new UserDTO ();
		u1.setId("user");
		u1.setName("1");
		userList.add(u1);
		
		UserDTO u2 = new UserDTO ();
		u2.setId("user2");
		u2.setName("2");
		userList.add(u2);
		
		System.out.println(userList.get(idx));
		
		return userList.get(idx);
	}
	
	@GetMapping("/user")
	public UserDTO run1(@RequestParam("id")String id,
						@RequestParam("name")String name) {
		UserDTO user = new UserDTO();
		user.setId(id);
		user.setName(name);
		System.out.println(user);
		return user;
		
	}
	
	
	@PostMapping("/user2")
	public UserDTO run2(@RequestBody UserDTO user) {
		System.out.println("run2:"+user.getId());
		System.out.println("run2:"+user);
		System.out.println(user==null);
		return user;
	}
	
	@PostMapping("/user3")
	public UserDTO run3 (@RequestParam("id")String id,
						@RequestParam("name")String name) {
		UserDTO user = new UserDTO();
		user.setId(id);
		user.setName(name);
		System.out.println(user);
		return user;
	}
	
	
	
	
	
	
	
}
