package com.example.test2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test2.dto.CommentDTO;

@Mapper
public interface ICommentDao {

	void writeComment(@Param("bno")String bno,@Param("c") CommentDTO comment);

	
}
