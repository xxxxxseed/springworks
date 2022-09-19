package com.cloud.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {

	private int rno;			//��� ��ȣ
	private int bno;			//�Խñ� ��ȣ
	
	private String reply;		//��� ����
	private String replyer;		//��� �ۼ���
	private Date replyDate;		//��� �ۼ���
	private Date updateDate;	//��� ������
}
