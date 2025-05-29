package com.example.jpaEx03.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_board3")
@Getter
@Setter
public class BoardEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // seq랑 같은거.
	private int bdNo;
	private String title;
	private String content;
	private String writerId;
}
