package com.spring.setterinject;

public class SonySpeaker implements Speaker{

	public SonySpeaker() {
		System.out.println("==> SonySpeaker ��ü ����");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker -- �Ҹ� �ø�");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker -- �Ҹ� ����");
	}

}
