package com.spring.consinject;

public class SamsungTV implements TV{

	private SonySpeaker speaker;	//���� ��ü ����
	
	//������ ������
	public SamsungTV(SonySpeaker speaker) {	//��ü�� �Ű������� ������
		this.speaker = speaker;
		System.out.println("SamsungTV() ��ü ����");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV--���� �Ҵ�");
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
