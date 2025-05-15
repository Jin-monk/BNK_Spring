package com.example.test03.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test03.dto.MovReserveDTO;

@Mapper
public interface IMovReserveDAO {

	void insertReserve(@Param("r") MovReserveDTO movReserve);

}
