package lambda;

public class MyFunctionalInterfaceTest {

	public static void main(String[] args) {
		
		MyFunctionalInterface fi;
		
		fi = (x) -> {
			x = x + 10;
			System.out.println(x);
		};
		fi.method(10);
		
		//���
		fi = (x) -> System.out.println(x + 10);
		fi.method(10);
		
		//������
		fi = (x) -> System.out.println(x * x);
		fi.method(4);
	}
}
