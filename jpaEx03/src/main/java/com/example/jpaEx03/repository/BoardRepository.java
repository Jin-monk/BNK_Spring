package com.example.jpaEx03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx03.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity,Integer>{

}
