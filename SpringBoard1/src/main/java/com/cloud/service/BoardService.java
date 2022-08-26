package com.cloud.service;

import java.util.List;

import com.cloud.repository.BoardVO;

public interface BoardService {

	public void insertBoard(BoardVO vo);	//�۾���(�߰�)
	
	public List<BoardVO> getBoardList();	//��� ����
	
	public BoardVO getBoard(int bno);		//�� �󼼺���
	
	public void deleteBoard(BoardVO vo);	//�� ����
	
	public void updateBoard(BoardVO vo);	//�� ����
	
	public void updateCount(int bno);		//��ȸ�� ����
}
