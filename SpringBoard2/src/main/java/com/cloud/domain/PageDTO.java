package com.cloud.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage;		//���� ������
	private int endPage;		//������ ������
	private boolean prev, next;	//����, ����
	
	private int total;			//�Խñ� �� ��
	private Criteria cri;		//������ ��ȣ, �������� �Խñ� �� ����
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//������(��) ������
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//���� ������
		this.startPage = this.endPage - 9;
		//���� �� ������
		int realEndPage = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		//�� ������ ����
		this.endPage = realEndPage < endPage ? realEndPage : endPage;
		
		this.prev = this.startPage > 1;				//����(�޴�)
		this.next = this.endPage < realEndPage;		//����
	}
}
