package com.cloud.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthVO implements Serializable{

	private static final long serialVersionUID = 12L;
	
	private String userid;	//아이디(기본키이면서 외래키)
	private String auth;	//권한(ROLE_USER, ROLE_ADMIN)

}
