package com.spring.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.user.UserDAO;
import com.spring.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. spring �����̳� ����
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. dao ó��
		//UserDAO userDAO = (UserDAO) container.getBean("userDAO");
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPasswd("test123");
		
		//boolean result = userDAO.login(vo);
		boolean result = userService.login(vo);
		if(result) {	//result == true
			System.out.println("�α��ο� �����߽��ϴ�.");
		}else {			//result == false
			System.out.println("���̵� ��й�ȣ�� Ȯ�����ּ���.");
		}
		
		//3. spring �����̳� ����
		container.close();
	}
}
