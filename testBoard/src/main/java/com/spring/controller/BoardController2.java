package com.spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.BoardVO2;
import com.spring.domain.ResultVO;
import com.spring.mapper.BoardMapper2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardController2 {
	private final BoardMapper2 boardMapper2;
	
	@PostMapping("/board")
	public ResultVO addBoard(@RequestBody BoardVO2 boardVO2) {
		int result = boardMapper2.insertBoard(boardVO2);
		if(result > 0) {
			return new ResultVO(0, "success");
		}else {
			return new ResultVO(100, "fail");
		}
	}
	
	@GetMapping("/board/{id}")
	public BoardVO2 findOne(@PathVariable int id) {
		return boardMapper2.findOneBoard(id);
	}
	
	@GetMapping("/boards")
	public List<BoardVO2> findAllBoard(){
		return boardMapper2.findBoard();
	}
}
