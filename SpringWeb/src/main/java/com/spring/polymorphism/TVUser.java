package com.spring.polymorphism;

public class TVUser {

	public static void main(String[] args) {
		//TV tv = new SamsungTV();	//�������̽��� ��ü(�ν��Ͻ�) ����
		TV tv = new LgTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		/*
		 * �������̽��� ��ü(�ν��Ͻ�)�� �����ؼ� ������ ����ȯ(�ڵ�����ȯ)��
		 * �̿��Ͽ� ��ü�� �����Ͽ� ���� ��ü ����
		 */
	}

}
