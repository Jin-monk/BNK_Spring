package com.example.ex04.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex04.dto.BoardDTO;

@Mapper
public interface IBoardDao {

	void write(@Param("board")BoardDTO board);

	List<BoardDTO> getList();

}
