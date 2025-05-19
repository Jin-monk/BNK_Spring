package com.example.examprogram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestResultDTO {

		private int resultNo;      // 시험 결과 PK (시퀀스)
	    private int testNo;        // 응시자(시험 참가자) 번호 (FK)
	    private int score;         // 총점
	    private int q1Choice;      // 1번 문제 선택(보기 번호)
	    private int q2Choice;      // 2번 문제 선택(보기 번호)
	    private int q3Choice;      // 3번 문제 선택(보기 번호)
	    private int q4Choice;      // 4번 문제 선택(보기 번호)
	    private int q5Choice;      // 5번 문제 선택(보기 번호)
	    private String regdate;  
}
