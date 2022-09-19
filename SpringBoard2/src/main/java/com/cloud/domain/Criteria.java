package com.cloud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
	private int pageNum;	//������ ��ȣ
	private int amount;		//�������� �Խñ� ��
	
	private String type;	//T, C, W, TC, TW, TCW(�迭, ����Ʈ, ��)
	private String keyword;	//�˻���
	
	public Criteria() {		//�⺻ ������(�Ű����� ���� ������)
		this(1, 10);		//�Ű����� ������ ȣ��
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//Ÿ���� ������ �޼��� ����(�迭�� ��ȯ, ���ڿ� �и�)
	public String[] getTypeArr() {
		//����, ���� ������ ���
		return type==null ? new String[] {} : type.split("");
	}
}
