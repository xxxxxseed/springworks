package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	@GetMapping("/all")
	public void doAll() {
		log.info("��� ����ڰ� ������ �� ����");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("�α����� ȸ��(���)");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("�α����� �����ڸ� ����");
	}
}
