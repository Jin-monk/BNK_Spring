package com.example.rest02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest02.dto.BoardDTO;
import com.example.rest02.entity.BoardEntity;
import com.example.rest02.repository.BoardRepository;
import com.example.rest02.util.Conversion;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	// 게시글 등록 업무(기능 = 함수) - registBoard : 준비 - 게시글, 결과 - ?
	public BoardEntity registBoard(BoardDTO board) {
		
		// DTO -> Entity 변환작업
		Conversion DTE = new Conversion();
		DTE.DTOToEntity(board);
		
//		BoardEntity boardEntity = new BoardEntity();
//		boardEntity.setTitle(board.getTitle());
//		boardEntity.setContent(board.getContent());
//		boardEntity.setWriter(board.getWriter());
		
		BoardEntity result = boardRepository.save(DTE.DTOToEntity(board));
		
		return result;
	}
	// 게시글 조회 업무 - getBoardByBno : 준비 - 조회할 게시물 bno , 결과 - ?
	public BoardEntity getBoardByBno(Integer bno) {
//		Optional<BoardEntity> result = boardRepository.findById(bno);
//		BoardEntity boardEntity = result.get();
		BoardEntity boardEntity = boardRepository.findByBno(bno);
		
		return boardEntity ;
	}
	
	// 게시글 수정 업무 - updateBoard : 준비 - 수정된 게시물, 결과 - ?
	public BoardEntity updateBoard(BoardDTO board) {
		// DTO -> Entity 변환작업
		Conversion DTE = new Conversion();
		DTE.DTOToEntity(board);
		
//		BoardEntity boardEntity = new BoardEntity();
//		boardEntity.setBno(board.getBno());
//		boardEntity.setTitle(board.getTitle());
//		boardEntity.setContent(board.getContent());
//		boardEntity.setWriter(board.getWriter());
		
		BoardEntity result = boardRepository.save(DTE.DTOToEntity(board));
		
		return result ;
	}
	
	// 게시글 삭제 업무 - deleteBoard : 준비 - 삭제할 게시물, 결과 - ? 
	public void deleteBoard (Integer bno) {
		boardRepository.deleteById(bno);
	}
}
