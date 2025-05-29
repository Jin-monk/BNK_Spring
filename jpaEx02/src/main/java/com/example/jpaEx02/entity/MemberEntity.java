package com.example.jpaEx02.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
