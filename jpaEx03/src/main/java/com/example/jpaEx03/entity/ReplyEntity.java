package com.example.jpaEx03.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_reply3")
@Getter
@Setter
public class ReplyEntity {

	@Id
	private int reNo;
	private int bdNo;
	private String id;
	private String content;
}
