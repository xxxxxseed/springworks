package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor		//기본 생성자
@AllArgsConstructor		//매개 변수가 있는 생성자
@Data
public class SampleVO {
	
	//필드
	private Integer mno;		//회원번호
	private String firstName;	//이름
	private String lastName;	//성
	
	/*public SampleVO(Integer mno, String firstName, String lastName) {
		super();
		this.mno = mno;
		this.firstName = firstName;
		this.lastName = lastName;
	}*/
}
