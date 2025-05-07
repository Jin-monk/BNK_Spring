package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;

	// 아이디 중복 여부 확인
	public int joinService(MemberDTO member) {
		// true: 중복 false: 중복아님
		boolean result = memberDao.selectOnlyId(member.getId());
		int insertRes = 0;
		if (result) {
			// 아이디중복
			System.out.println("ID 중복");
		} else {
			// 중복아니면 DB INSERT
			insertRes = memberDao.insert(member);
		}

		// 회원 가입 성공 여부
		if (insertRes == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("ID 중복으로 인한 회원가입 실패");
		}
		return insertRes;
	}

	// PW 동일 여부 확인
	public boolean checkPw(String pw, String checkPw) {
		boolean checkPwRes = pw.equals(checkPw);

		if (checkPwRes) {
			System.out.println("비밀번호 동일");
		} else {
			System.out.println("비밀번호 다름!!!!! ");
		}

		return checkPwRes;
	}

	// 로그인 ID 및 PW 확인
	public boolean checkIdPw(String id, String pw) {
		MemberDTO member = memberDao.viewMember(id);
		if (member.getId().equals(id) && member.getPw().equals(pw)) {
			System.out.println("로그인성공");
			return true;
		} else {
			System.out.println("로그인 실패");
			return false;
		}
	}

}
