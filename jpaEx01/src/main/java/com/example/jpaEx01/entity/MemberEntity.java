package com.example.jpaEx01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // DB 의 테이블이 된다. 
@Table(name = "tbl_member2") // 테이블 이름 정의.
@Getter
@Setter
public class MemberEntity {
	
	@Id  // PK 를 정의.
	private String username;
	private String password;
	private String name;
	private String role;
	
	
}
