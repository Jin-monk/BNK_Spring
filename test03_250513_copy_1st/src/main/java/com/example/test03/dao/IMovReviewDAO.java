package com.example.test03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test03.dto.MovReviewDTO;

@Mapper
public interface IMovReviewDAO {

	List<MovReviewDTO> getReview(@Param("movNo") int movNo);

	void writeReview(@Param("r") MovReviewDTO movReview);

	void deleteReview(@Param("reviewNo") int reviewNo);

	MovReviewDTO getReviewByReviewNo(@Param("reviewNo") int reviewNo);

	
}
