package com.example.ex01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ex01.dto.MemberDTO;

@Mapper
public interface IMemberDAO {

	MemberDTO getMember();

	List<MemberDTO> getMemberAll();

	


	
}
