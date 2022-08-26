package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.UserVO;
import com.cloud.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView() {		//�α��� �� ������ ��û
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session, Model model) {		//�α��� ó�� ��û
		boolean result = service.login(vo);
		
		if(result) {
			session.setAttribute("sessionId", vo.getId());	//id ���� �߱�
			return "redirect:boardList";
		}else {
			int error = 1;
			model.addAttribute("error", error);				//model ������ - error
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {				//�α� �ƿ� ó��
		session.invalidate();	//���� ����
		return "index";
	}
}
