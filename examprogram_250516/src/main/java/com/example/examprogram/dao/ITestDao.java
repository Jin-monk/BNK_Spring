package com.example.examprogram.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.examprogram.dto.TestDTO;

@Mapper
public interface ITestDao {

	void insertTest(@Param("t") TestDTO tester);

}
