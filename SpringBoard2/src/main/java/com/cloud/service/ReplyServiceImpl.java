package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.domain.ReplyVO;
import com.cloud.mapper.BoardMapper;
import com.cloud.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	//���� �������̽� ����(DI) - ��ü(Bean) ������
	@Autowired
	private ReplyMapper replyMapper;
	
	@Autowired
	private BoardMapper boardMapper;

	//��� ���
	@Override
	public List<ReplyVO> getReplyList(int bno) {
		return replyMapper.getReplyList(bno);
	}

	//��� ��� - ��� ���� ����, Ʈ�����: �۾� �Ϻ��ϰ� �Ϸ���� ������ �����
	//��� ����ϸ� ��� ������ ������
	@Transactional
	@Override
	public void register(ReplyVO vo) {
		//��� ����
		boardMapper.updateReplyCnt(vo.getBno(), 1);		//1 - amount
		replyMapper.register(vo);
	}

}
