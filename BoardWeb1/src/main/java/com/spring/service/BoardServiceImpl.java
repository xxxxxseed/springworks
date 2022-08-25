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

	@Autowired	//필드(멤버) 이름 위에 사용하면 객체 컨텐츠 주입됨
	private BoardDAO boardDAO;
	
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	//생성자
	public BoardServiceImpl() {	//BoardServiceImpl 객체가 생성될때
		//log = new LogAdvice();	//LogAdvice 객체도 함께 생성됨
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {	//글 등록 서비스
		//log.printLog();						//등록 서비스 전에 실행
		//log.printLogging();
		boardDAO.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {	//글 목록 서비스
		//log.printLog();						//등록 서비스 전에 실행
		//log.printLogging();
		return boardDAO.getBoardList();
	}

}
