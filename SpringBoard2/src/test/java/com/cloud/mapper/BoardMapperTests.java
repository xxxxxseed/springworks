package com.cloud.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	/*@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getBoardList();
		
		list.stream()
			.map(board -> board.getBno())		//글번호 매핑
			.forEach(board -> log.info(board));	//글번호 출력
	}*/
	
	/*@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(2);	//1페이지
		cri.setAmount(10);	//게시글 수 - 10개
		
		List<BoardVO> list = mapper.getListWithPage(cri);
		
		list.stream()
			.map(board -> board.getBno())		//글번호 매핑
			.forEach(board -> log.info(board));	//글번호 출력
	}*/
	
	/*@Test
	public void testPageDTO() {
		Criteria cri = new Criteria();
		//cri.setPageNum(1);	//startPage - 1 페이지
		cri.setPageNum(11);		//startPage - 11 페이지
		
		PageDTO page = new PageDTO(cri, 225);
		log.info(page);
	}*/
	
	/*@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "사과");
		map.put("C", "java");
		map.put("W", "user00");
		
		//중첩 Map
		Map<String, Map<String, String>> outer = new HashMap<>();
		outer.put("map", map);		//xml쪽의 collection="map"
		
		List<BoardVO> list = mapper.searchTest(outer);
		
		log.info(list);
	}*/
	
	@Test
	public void testSearchPaging() {
		//검색 종류와 키워드 입력
		Criteria cri = new Criteria();
		cri.setType("T");
		cri.setKeyword("빨");
		
		List<BoardVO> list = mapper.getListWithPage(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	
}
