package com.spring.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		//1. spring �����̳� ����
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. BoardDAO ó�� -> BoardService ó��
		//BoardDAO boardDAO = (BoardDAO) container.getBean("boardDAO");
		BoardService boardService = 
				(BoardService) container.getBean("boardService");
		
		//�� ����
		BoardVO vo = new BoardVO();
		vo.setTitle("�ȳ��ϼ���");
		vo.setWriter("�쿵��");
		vo.setContent("���� ��õ���� �����߾��");
		//boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		
		//�� ���
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		//3. spring �����̳� ����
		container.close();
	}
}
