package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;

@RestController
@RequestMapping("/api/board-get")
public class GetBoardController {

	@Autowired
	private BoardService boardService;
	
	// 게시글 조회
	@GetMapping("/board/{bno}")
	public ResponseEntity<BoardEntity> searchBoard(@PathVariable("bno")Integer bno) {
		BoardEntity result = boardService.getBoardByBno(bno);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	
	
	
	
}
