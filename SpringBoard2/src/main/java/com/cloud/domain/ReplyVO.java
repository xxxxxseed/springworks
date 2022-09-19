package com.cloud.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {

	private int rno;			//´ñ±Û ¹øÈ£
	private int bno;			//°Ô½Ã±Û ¹øÈ£
	
	private String reply;		//´ñ±Û ³»¿ë
	private String replyer;		//´ñ±Û ÀÛ¼ºÀÚ
	private Date replyDate;		//´ñ±Û ÀÛ¼ºÀÏ
	private Date updateDate;	//´ñ±Û ¼öÁ¤ÀÏ
}
