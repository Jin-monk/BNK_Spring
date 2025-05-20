package com.example.ex04.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class BoardDTO {

	@NotBlank(message = "제목은 필수 입력값입니다.")
	private String title;
	private String content;
	@NotBlank(message = "작성자는 필수 입력값입니다.")
	private String writer;
	private String regdate;
	
}
