package com.example.rest02.util;

import com.example.rest02.dto.BoardDTO;
import com.example.rest02.entity.BoardEntity;

public class Conversion {

	public BoardEntity DTOToEntity(BoardDTO dto) {
		
		BoardEntity entity = new BoardEntity();
		entity.setBno(dto.getBno());
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setWriter(dto.getWriter());
		return entity;
	}
	
	
	public BoardDTO EntityToDTO(BoardEntity entity) {
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBno(entity.getBno());
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setWriter(entity.getWriter());
		dto.setRegDate(entity.getRegDate());
		dto.setModDate(entity.getModDate());
	
		return dto;
	}
	
	
}
