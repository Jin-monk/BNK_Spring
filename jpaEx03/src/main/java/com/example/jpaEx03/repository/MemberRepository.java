package com.example.jpaEx03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx03.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,String>{

	int countByIdAndPw(String id, String pw);


}
