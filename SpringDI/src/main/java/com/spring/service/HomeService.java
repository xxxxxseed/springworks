package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.vo.FriendVO;
import com.spring.vo.FriendVO2;

@Service
public class HomeService {

	public void sayHello() {
		//System.out.println("�ȳ��ϼ���~");
		FriendVO vo1 = new FriendVO();
		vo1.setName("�Ȼ�");
		vo1.setAge(21);
		
		FriendVO2 vo2 = new FriendVO2("�ȿ���", 31);
		
		System.out.println(vo1.getName() + "�� �ȳ��ϼ���~");
		System.out.println(vo2.getName() + "�� �ȳ��ϼ���~");
	}
}
