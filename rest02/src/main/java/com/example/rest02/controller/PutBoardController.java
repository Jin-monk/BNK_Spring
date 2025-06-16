package com.example.rest02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest02.dto.BoardDTO;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.service.BoardService;

@RestController
@RequestMapping("/api/board-put")
public class PutBoardController {

	@Autowired
	private BoardService boardService;
	
	@PutMapping("/board")
	public ResponseEntity<BoardEntity> putBoard(@RequestBody BoardDTO board){
		BoardEntity result = boardService.updateBoard(board);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}
