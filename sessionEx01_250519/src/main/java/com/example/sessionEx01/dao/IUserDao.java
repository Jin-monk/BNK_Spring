package com.example.sessionEx01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sessionEx01.dto.UserDTO;

import jakarta.validation.Valid;

@Mapper
public interface IUserDao {

	UserDTO login(@Param("id")String id, @Param("pw")String pw);
	
	List<UserDTO> getUserList();
	
	List<UserDTO> getUserListWithParam(@Param("user")UserDTO user);

	List<UserDTO> getUserListWithParam2(@Param("user")UserDTO user);

	void createUser(@Valid @Param("user")UserDTO user);
}
