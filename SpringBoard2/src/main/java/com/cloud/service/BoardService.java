package com.cloud.service;

import java.util.List;

import com.cloud.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> getBoardList();	//�� ��� ����
	
	public void insert(BoardVO vo);			//�۾���
	
	public BoardVO getBoard(int bno);		//�� �� ����
	
	public void delete(BoardVO vo);			//�� ����
	
	public void update(BoardVO vo);			//�� ����
	
	public void updateCount(int bno);		//��ȸ��
}
