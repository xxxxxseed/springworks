package com.spring.setterinject;

public class LgTV implements TV{

	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("==> LgTV() ��ü ����");
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
		System.out.println("LgTV--���� �Ҵ� (����:" + price + ")");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV--���� ����");
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
