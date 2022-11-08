package streamex;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		
		bookList.add(new Book("자바", 25000));
		bookList.add(new Book("파이썬", 19000));
		bookList.add(new Book("안드로이드", 30000));
		
		int total = bookList.stream().mapToInt(b -> b.getPrice())
										.sum();
		
		System.out.println("모든 책의 가격의 합 : " + total);
		
		bookList.stream().filter(b -> b.getPrice() >= 20000)
							.map(b -> b.getName())
							.sorted()
							.forEach(s -> System.out.println(s));
	}

}
