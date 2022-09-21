package com.cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/exam")
@RestController
public class ExController {
	//���ڿ� �����ϱ�
	@GetMapping(value="/getText", produces="text/plain; charset=utf-8" )
	public String getText() {	//produces �Ӽ��� ����Ͽ� �ѱ� ����
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "�ȳ�~ Rest";
	}
	
	//VO ��ü �����ϱ�
	@GetMapping(value="/getSample",
				produces= {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "�⽺", "��Ƽ��");
	}
	
	//collection(����Ʈ) �����ϱ�
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10)
				.mapToObj(i -> new SampleVO(i, i+"First", i+"Last"))
				.collect(Collectors.toList());
	}
	
	//collection(Map) �����ϱ�
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(112, "Bill", "Gates"));
		return map;
	}
	
	//@PathVariable - URL ��� �Ϻθ� �Ķ���ͷ� ���
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
							@PathVariable("cat") String cat,
							@PathVariable("pid") String pid) {
		return new String[] {"categoriy: " + cat, "productid: " + pid};
	}
	
	//@RequestBody - ���޵� ������ �̿��ؼ� �ش� �Ķ������ Ÿ������ ��ȯ�� ��û
	@PostMapping("/ticket")
	@ResponseBody
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert......ticket" + ticket);
		return ticket;
	}
}
