package com.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.BoardService;
import com.app.dto.TestDTO;
import com.app.entity.Board;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Board")
public class BoardController {

	//데이터 조회용 컨트롤러
	
	private final BoardService BS;
	
	@GetMapping(value = {"/findList", "/findList/{accept:[0-1]}"})
	public TestDTO findList(@PathVariable(name = "accept", required = false) String accept) {
		return BS.findList(accept);
	}
	
	@GetMapping("/detail/{no:[0-9]+}")
	public TestDTO findOne(@PathVariable("no") int no) {
		return BS.fineOne(no);
	}
	
	@GetMapping("/save/no{no:[0-9]+}/{accept:[0-1]}")
	public TestDTO save(@PathVariable("no") int no, @PathVariable("accpet") boolean accept) {
		return BS.accept(no, accept);
	}
	
	@PostMapping("/save")
	public TestDTO save(@ModelAttribute Board board) {
		return BS.save(board);
	}
	
	@GetMapping(value = {"/list","/list/{accept:[0-1]}"})
	public String list(Model model,@PathVariable (name = "accept", required = false) String accept) {
		model.addAttribute("list", BS.findList(accept).getResult());
		return "list";
	}
	
	
	
	
}
