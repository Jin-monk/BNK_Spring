package com.example.sessionEx01.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.sessionEx01.dto.UserDTO;


@Component
@SessionScope
public class UserSession {
	private UserDTO loginUser; // 로그인 사용자 정보 저장용 객체
	
	// 로그인 처리
	public void login(UserDTO user) {
		loginUser = user ; 
	}
	
	// 로그아웃 처리
	public void logout() {
		loginUser = null;
	}
	
	// 현재 로그인 여부 확인
	public boolean isLoggedIn() {
		if(loginUser!= null){
			return true;  //로그인 된 상태
		}else {
			return false;  //로그아웃 된 상태
		}
	}
	
	// 사용자 정보 조회
	public UserDTO getLoginUser() {
		return loginUser;
	}
	
	
}
