package lambda;

public class MyFunctionalTest {

	public static void main(String[] args) {
		
		MyFunctionalEx fi;		//�������̽� ��ü ����
		
		//���� �Լ��� ����
		fi = () -> {
			String str = "Hello~ Lambda!!";
			System.out.println(str);
		};
		fi.method();			//�ʼ� ȣ��
		
		//��� ����
		fi = () -> System.out.println("Hello~ Lambda!!");
		fi.method();
	}
}
