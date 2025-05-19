package com.example.sessionEx01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sessionEx01.dto.UserDTO;

@Mapper
public interface IUserDao {

	UserDTO login(@Param("id")String id, @Param("pw")String pw);
}
