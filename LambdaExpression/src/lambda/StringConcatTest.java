package lambda;

public class StringConcatTest {

	public static void main(String[] args) {
		System.out.println("*** �Ϲ� ���� Ŭ���� ***");
		StringConcat str = new StringConcatImpl();
		
		str.makeString("��", "������Ʈ");
		
		System.out.println("*** ���ٽ����� ���� ***");
		StringConcat str2;
		str2 = (s1, s2) -> System.out.println(s1 + " " + s2);
		str2.makeString("��", "������Ʈ");
	}
}
