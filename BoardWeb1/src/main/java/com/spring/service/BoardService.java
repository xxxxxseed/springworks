package com.spring.service;

import java.util.List;

import com.spring.board.BoardVO;

public interface BoardService {
	//�� ���
	public void insertBoard(BoardVO vo);
	
	//�� ���
	public List<BoardVO> getBoardList();
}
