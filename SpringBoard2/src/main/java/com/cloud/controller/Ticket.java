package com.cloud.controller;

import lombok.Data;

@Data
public class Ticket {
	//필드
	private int tno;		//티켓 번호
	private String owner;	//소유주
	private String grade;	//등급
}
