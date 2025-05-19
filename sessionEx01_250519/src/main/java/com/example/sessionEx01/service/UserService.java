package com.example.sessionEx01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sessionEx01.dao.IUserDao;
import com.example.sessionEx01.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private IUserDao userDao;
	
	public UserDTO loginCheck (String id, String pw) {
		return userDao.login(id,pw);
	}
}
