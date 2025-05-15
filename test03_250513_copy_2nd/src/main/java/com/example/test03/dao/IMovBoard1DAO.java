package com.example.test03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test03.dto.MovBoard1DTO;

@Mapper
public interface IMovBoard1DAO {

	List<MovBoard1DTO> getAll();

	MovBoard1DTO getOneBybd1No(@Param("bd1No") int bd1No);

	
}
