package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired	//�ʵ�(���) �̸� ���� ����ϸ� ��ü ������ ���Ե�
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {	//�� ��� ����
		boardDAO.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {	//�� ��� ����
		return boardDAO.getBoardList();
	}

}
