package com.cloud.repository;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {
	private int bno;		//�۹�ȣ
	private String title;	//����
	private String writer;	//�ۼ���
	private String content;	//����
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDate;	//�ۼ���
	private int cnt;		//��ȸ��
}
