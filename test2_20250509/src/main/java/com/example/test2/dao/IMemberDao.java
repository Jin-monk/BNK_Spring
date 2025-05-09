package com.example.test2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test2.dto.MemberDTO;

@Mapper
public interface IMemberDao {

	
	void joinMember(@Param("m") MemberDTO member);

	MemberDTO loginCheck(@Param("id")String id, @Param("pw") String pw);

	List<MemberDTO> memberList();

	
	


	
	
}
