package com.cloud.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserVO {

	private String id;
	private String passwd;
	private String name;
	private String role;
}
