package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {

	//��� ��� ����
	List<ReplyVO> getReplyList(int bno);
	
	//��� ���
	void register(ReplyVO vo);
}
