package lambda;

public class StringConcatTest {

	public static void main(String[] args) {
		System.out.println("*** 일반 구현 클래스 ***");
		StringConcat str = new StringConcatImpl();
		
		str.makeString("힐", "스테이트");
		
		System.out.println("*** 람다식으로 구현 ***");
		StringConcat str2;
		str2 = (s1, s2) -> System.out.println(s1 + " " + s2);
		str2.makeString("힐", "스테이트");
	}
}
