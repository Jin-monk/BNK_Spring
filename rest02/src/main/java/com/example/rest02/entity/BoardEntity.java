package com.example.rest02.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_board1")
@Data

public class BoardEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bno ; 
	private String title;
	private String content;
	private String writer;
//	@Column(name="regdate")     -> BaseEntity 로 이동 
//	private LocalDateTime regDate; // 등록시간
//	@Column(name="moddate")
//	private LocalDateTime modDate; // 수정시간
	
	
}
