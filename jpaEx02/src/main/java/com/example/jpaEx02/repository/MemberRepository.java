package com.example.jpaEx02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx02.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,String>{

}
