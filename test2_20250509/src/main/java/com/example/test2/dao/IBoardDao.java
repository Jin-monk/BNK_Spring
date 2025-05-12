package com.example.test2.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test2.dto.BoardDTO;

@Mapper
public interface IBoardDao {

	List<BoardDTO> boardList();

	BoardDTO getBorad(@Param("title") String title);

	void boardUpdate(@Param("b") BoardDTO board);

	BoardDTO getBoardByBno(@Param("bno")String bno);

	void deleteBoard(@Param("bno") String bno);

	//더미데이터 넣기 
	int insert (@Param("board")BoardDTO board);

	List<BoardDTO> pagination(@Param("start")int start, @Param("end")int end);

	void writeBoard(@Param("b") BoardDTO board);

	int getBoardCount();
}
