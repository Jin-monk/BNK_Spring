package com.example.test2.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test2.dto.BoardDTO;

@Mapper
public interface IBoardDao {

	List<BoardDTO> boardList();

	BoardDTO getBorad(String title);

	void boardUpdate(@Param("b") BoardDTO board);

	void getBoardByWriter(String id);

	
}
