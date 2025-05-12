package com.example.test2.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.test2.dto.BoardDTO;

@SpringBootTest
class BoardDaoTest {
	
	@Autowired
	IBoardDao boardDao;

	@Test
	void testInsert() {
		for(int i = 106 ; i < 112; i ++) {
			BoardDTO board = new BoardDTO();
			board.setTitle("Title..." + i);
			board.setContent("Content" + i);
			board.setWriter("test");
			board.setRegdate("2025-05-02");
			boardDao.insert(board);
		}
	}

}
