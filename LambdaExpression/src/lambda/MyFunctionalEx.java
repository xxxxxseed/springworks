package lambda;

@FunctionalInterface	//어노테이션을 명시하면 컴파일러가 바로 오류 체크함
public interface MyFunctionalEx {
	//추상 메서드는 1개만 사용 가능함
	public void method();
	
	//public void method(int x);
}
