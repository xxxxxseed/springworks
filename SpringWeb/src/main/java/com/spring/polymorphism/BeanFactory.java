package com.spring.polymorphism;

public class BeanFactory {

	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
		
		//getBean() �޼ҵ�� �Ű������� ���� beanName�� �ش��ϴ�
		//��ü�� �����Ͽ� �����Ѵ�.
	}
}
