package com.spring.controller;

import org.springframework.test.context.TestConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.ResultVO;


@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello test";
	}
	
	@GetMapping("/hello2")
	public String hello2(@RequestParam("name") String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/hello3/{name}")
	public String hello3(@PathVariable String name) {
		return "Hello " + name; 
	}
	
	//@RequestMapping(value="/hello4", method=RequestMethod.POST)
	@PostMapping("/hello4")
	public String hello4(@RequestParam("name") String name) {
		System.out.println(name);
		return "Hello " + name;
	}
	
	//@RequestMapping(value="/hello5", produces="application/json", method=RequestMethod.POST)
	@PostMapping("/hello5")
	public ResultVO hello5(@RequestParam("name") String name) {
		ResultVO result = new ResultVO(0, name);
		System.out.println(name);
		return result;
	}
	
	@PostMapping("/hello6")
	public ResultVO hello6(@RequestBody ResultVO result) {
		return result;
	}
}
