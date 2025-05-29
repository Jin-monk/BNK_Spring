package com.example.jpaEx03.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_member3")
@Getter
@Setter
public class MemberEntity {
	
	@Id
	private String id;
	private String pw;
	private String name;
	private String role;
	
}
