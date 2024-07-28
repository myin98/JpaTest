package com.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndextController {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "메이플 로아 아로나 Let's Go");
		model.addAttribute("img", "image/i1614648353.jpg");
		return "hello";
	}
	
}
