package com.cloud.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	//�ʵ�(���)
	private String id;
	private String passwd;
	private String name;
	private String role;
}
