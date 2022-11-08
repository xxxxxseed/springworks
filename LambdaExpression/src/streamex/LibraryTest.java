package streamex;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		
		bookList.add(new Book("�ڹ�", 25000));
		bookList.add(new Book("���̽�", 19000));
		bookList.add(new Book("�ȵ���̵�", 30000));
		
		int total = bookList.stream().mapToInt(b -> b.getPrice())
										.sum();
		
		System.out.println("��� å�� ������ �� : " + total);
		
		bookList.stream().filter(b -> b.getPrice() >= 20000)
							.map(b -> b.getName())
							.sorted()
							.forEach(s -> System.out.println(s));
	}

}
