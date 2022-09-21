package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {

	//´ñ±Û ¸ñ·Ï º¸±â
	List<ReplyVO> getReplyList(int bno);
	
	//´ñ±Û µî·Ï
	void register(ReplyVO vo);
	
	//Æ¯Á¤ ´ñ±Û Á¶È¸
	ReplyVO getReply(int rno);
	
	//´ñ±Û »èÁ¦
	void deleteReply(ReplyVO vo);
	
	//´ñ±Û ¼öÁ¤
	void update(ReplyVO vo);
}
