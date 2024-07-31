package com.app.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.Service.BoardService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
//@AllArgsConstructor
public class IndextController {
	
	private final BoardService BS;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "메이플 로아 아로나 Let's Go");
		model.addAttribute("img", "image/i1614648353.jpg");
		return "hello";
	}
	
	@GetMapping(value = {"/list","/list/{accept:[0-1]}"})
	public String list(Model model,@PathVariable (name = "accept", required = false) String accept) {
		model.addAttribute("list", BS.findList(accept).getResult());
		return "list";
	}
	
}
