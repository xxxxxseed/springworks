package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

//�ð��� �˻��ϴ� �������̽�
public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
}
