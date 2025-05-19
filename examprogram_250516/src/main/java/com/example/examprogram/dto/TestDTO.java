package com.example.examprogram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestDTO {

	private int testNo;
	private String name;
	private int birthDate;
	private String gender;
	
}
