package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;
import com.spring.common.Log4jAdvice;
import com.spring.common.LogAdvice;

@Service("boardService")	//@Component
public class BoardServiceImpl implements BoardService{

	@Autowired	//�ʵ�(���) �̸� ���� ����ϸ� ��ü ������ ���Ե�
	private BoardDAO boardDAO;
	
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	//������
	public BoardServiceImpl() {	//BoardServiceImpl ��ü�� �����ɶ�
		//log = new LogAdvice();	//LogAdvice ��ü�� �Բ� ������
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {	//�� ��� ����
		//log.printLog();						//��� ���� ���� ����
		//log.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {	//�� ��� ����
		//log.printLog();						//��� ���� ���� ����
		//log.printLogging();
		return boardDAO.getBoardList();
	}

}
