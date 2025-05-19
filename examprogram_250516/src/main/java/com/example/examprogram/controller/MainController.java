package com.example.examprogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.examprogram.dao.ITestDao;
import com.example.examprogram.dto.TestDTO;
import com.example.examprogram.dto.TestResultDTO;

@Controller
public class MainController {

	@Autowired
	private ITestDao testDao;
	
	@GetMapping("/")
	public String root() {
		System.out.println("root");
		return "index";
	}
	
	
	@PostMapping("/toExam")
	public String toExam(TestDTO tester,Model model) {
		System.out.println("toExam...");
		testDao.insertTest(tester);
		System.out.println(tester.getTestNo());
		model.addAttribute("tester", tester);
		return "exam";
	}
	
	
	@PostMapping("/checkResult")
	public String checkResult(TestResultDTO testResult,
								Model model) {
		int score = 0;
		boolean answer1 = false;
		boolean answer2 = false;
		boolean answer3 = false;
		boolean answer4 = false;
		boolean answer5 = false;
		if(testResult.getQ1Choice() ==1) {
			score += 20 ;
			answer1 = true;
		}
		if(testResult.getQ2Choice() ==1) {
			score += 20 ;
			answer2 = true;
		}
		if(testResult.getQ3Choice() ==1) {
			score += 20 ;
			answer3 = true;
		}
		if(testResult.getQ4Choice() ==1) {
			score += 20 ;
			answer4 = true;
		}
		if(testResult.getQ5Choice() ==1) {
			score += 20 ;
			answer5 = true;
		}
		
		testResult.setScore(score);
		System.out.println(testResult);
		model.addAttribute("score", score);
		return "examResult";
	}
}
