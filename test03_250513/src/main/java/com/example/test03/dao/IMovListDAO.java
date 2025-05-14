package com.example.test03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test03.dto.MovListDTO;

@Mapper
public interface IMovListDAO {

	List<MovListDTO> getAll();

	MovListDTO getOneByMovNo(@Param("movNo") int movNo);
	
	
}
