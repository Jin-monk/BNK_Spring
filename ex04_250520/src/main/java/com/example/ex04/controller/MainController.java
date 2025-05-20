package com.example.ex04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex04.dao.IBoardDao;
import com.example.ex04.dto.BoardDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/board")
public class MainController {

	@Autowired
	private IBoardDao boardDao;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard(@Valid BoardDTO board,
						BindingResult result,
						Model model) {
		if(result.hasErrors()) {
			if(result.getFieldError("title") != null) {
				String errorMsg = result.getFieldError("title").getDefaultMessage();
				model.addAttribute("errorMsg", errorMsg);
				System.out.println(errorMsg);
			}
			if(result.getFieldError("writer") != null) {
				String errorMsg2 = result.getFieldError("writer").getDefaultMessage();
				model.addAttribute("errorMsg2", errorMsg2);
				System.out.println(errorMsg2);
			}
		}
		if(result.hasErrors() == false) {
			boardDao.write(board);
			return "redirect:/showBoard";
		}
		return "redirect:/";
		
	}
	
	@GetMapping("/showBoard")
	public String showBoard(Model model) {
		List<BoardDTO> list = boardDao.getList();
		model.addAttribute("list", list);
		return "showBoard";
	}
	
	
	
}
