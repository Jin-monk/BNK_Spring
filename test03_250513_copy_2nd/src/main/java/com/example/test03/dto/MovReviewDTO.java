package com.example.test03.dto;

import lombok.Data;

@Data
public class MovReviewDTO {

	private int reviewNo;
	private int movNo;
	private String writerId;
	private String revContent;
	private String revDate;
}
