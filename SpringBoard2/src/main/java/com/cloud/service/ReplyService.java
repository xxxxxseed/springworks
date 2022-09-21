package com.cloud.service;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyService {

	//��� ���
	public List<ReplyVO> getReplyList(int bno);
	
	//��� ���
	public void register(ReplyVO vo);
	
	//Ư�� ��� ��ȸ
	public ReplyVO getReply(int rno);
		
	//��� ����
	public void deleteReply(ReplyVO vo);
	
	//��� ����
	public void update(ReplyVO vo);
}
