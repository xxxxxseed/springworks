package lambda;

public class MyNumberTest {

	public static void main(String[] args) {

		MyNumber num;
		
		//�̸� ���� �Լ�(�͸� �Լ�)
		num = (x, y) -> {
			return (x >= y) ? x : y;
		};
		
		System.out.println("�ִ밪 : " + num.getMax(10, 20));
		
		//��� - {}�� return ���� ����. �ڵ尡 1���϶� ����
		num = (x, y) -> (x >= y) ? x : y;
		System.out.println("�ִ밪 : " + num.getMax(20, 10));
	}
}
