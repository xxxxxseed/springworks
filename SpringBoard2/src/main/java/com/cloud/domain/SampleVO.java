package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor		//�⺻ ������
@AllArgsConstructor		//�Ű� ������ �ִ� ������
@Data
public class SampleVO {
	
	//�ʵ�
	private Integer mno;		//ȸ����ȣ
	private String firstName;	//�̸�
	private String lastName;	//��
	
	/*public SampleVO(Integer mno, String firstName, String lastName) {
		super();
		this.mno = mno;
		this.firstName = firstName;
		this.lastName = lastName;
	}*/
}
