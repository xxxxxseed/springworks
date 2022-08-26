package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.BoardDAO;
import com.cloud.repository.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;	//BoardDAO를 주입받아 객체 생성
	
	@Override
	public void insertBoard(BoardVO vo) {	//글쓰기
		dao.insertBoard(vo);
	}
	
	@Override
	public List<BoardVO> getBoardList() {	//목록 보기 서비스
		return dao.getBoardList();
	}

	@Override
	public BoardVO getBoard(int bno) {		//글 상세 보기
		return dao.getBoard(bno);
	}

	@Override
	public void deleteBoard(BoardVO vo) {	//글 삭제
		dao.deleteBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {	//글 수정
		dao.updateBoard(vo);
	}

	@Override
	public void updateCount(int bno) {		//조회수 증가
		dao.updateCount(bno);
	}


}
