package com.example.test01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test01.dto.MemberDTO;

@Mapper
public interface IMemberDao {
	
	//@Select("SELECT * FROM TBL_MEMBER")
	List<MemberDTO> getList();

	
	//@Select("SELECT * FROM TBL_MEMBER WHERE ID = #{id} ")
	MemberDTO getMember(@Param("id")String id);
	
	
	//@Update("UPDATE tbl_member SET pw=#{m.pw}, name=#{m.name}, phone=#{m.phone}, grade=#{m.grade} WHERE id = #{m.id}")
	void update(@Param("m")MemberDTO member);

	
	//@Delete("DELETE FROM tbl_member WHERE ID = #{id}")
	void delete(@Param("id")String id);
	
	
	void insert(@Param("m")MemberDTO member);
	
}
