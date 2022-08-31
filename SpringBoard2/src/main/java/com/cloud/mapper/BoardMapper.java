package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.BoardVO;

//DAO ����
public interface BoardMapper {
	
	public List<BoardVO> getBoardList();	//�� ��� ����
	
	public void insertBoard(BoardVO vo);	//�۾���
	
	public BoardVO getBoard(int bno);		//�� �� ����
	
	public void deleteBoard(BoardVO vo);	//�� ����
	
	public void updateBoard(BoardVO vo);	//�� ����
	
	public void updateCount(int bno);		//��ȸ��
}
