package com.spring.annotation;

public class SamsungTV implements TV{

	private Speaker speaker;	//�������̽��� ���� ��ü ����
	private int price;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV() ��ü ����");
	}
	
	//setter ������
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("==> setSpeaker() ȣ��");
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV--���� �Ҵ�. (����:" + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV--���� ����");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
