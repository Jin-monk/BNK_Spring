package com.example.test03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test03.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	//ID 중복체크
	MemberDTO getIdById(@Param("id")String id);
	//회원가입 성공 시 INSERT 
	void joinMember(MemberDTO member);
	//로그인 id,pw 가져오기
	MemberDTO loginCheck(@Param("id") String id,@Param("pw") String pw);

}
