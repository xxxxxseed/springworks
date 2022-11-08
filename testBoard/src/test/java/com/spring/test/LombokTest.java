package com.spring.test;

import org.junit.Test;

import com.spring.domain.ResultVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class LombokTest {

	@Test
	public void ResultTest() {
		ResultVO result = new ResultVO(0, "hong");
		log.info(result);
	}
}
