package net.cloud.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import net.cloud.domain.SampleVO;

@Log4j
@RequestMapping("/sample/*")	//Url ��� ����
@Component
public class SampleController {

	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public void basic() {
		log.info("basic get......");
	}
	
	@GetMapping("/basicGet")	//get��� - RequestMethod.GET�� ����
	public void basicGet() {
		log.info("basic get only get......");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleVO vo) {
		log.info(vo);
		return "ex01";
	}
	
	//������ �̸��� �Ķ���Ͱ� ������ ���޵� ���
	//RequestParam - ���� ������ �̸��� ���޵Ǵ� �Ķ������ �̸��� �ٸ� ��쿡 ���
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	//ex03.jsp�� �����ϱ�
	@GetMapping("/ex03")
	public String ex03(SampleVO sampleVO, @ModelAttribute("page") int page) {
		log.info("vo: " + sampleVO);
		log.info("page: " + page);
		return "ex03";
	}
}
