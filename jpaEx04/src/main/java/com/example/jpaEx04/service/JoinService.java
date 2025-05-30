package com.example.jpaEx04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jpaEx04.dto.UserDTO;
import com.example.jpaEx04.entity.User;
import com.example.jpaEx04.repository.UserRepository;

@Service

public class JoinService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User regist(UserDTO userDTO) {
		// 서비스단에서 컨트롤러에서 전달한 파라미터를 받음.
		
		// 파라미터 중 비밀번호를 암호화 처리.
		String newPw = bCryptPasswordEncoder.encode(userDTO.getPassword());
		
		// DTO를 Entity 로 바꾸는 작업.
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(newPw);
		user.setName(userDTO.getName());
		
		// username 이 'admin'이면 "ROLE_ADMIN" / 아니면 "ROLE_MEMBER"
		if(userDTO.getUsername().equals("admin")) {
			user.setRole("ROLE_ADMIN");
		}else {
			user.setRole("ROLE_MEMBER");
		}
		
		// DB에 회원정보 저장.
		return userRepository.save(user);
	}
}
