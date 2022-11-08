package streamex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		/*List<String> companyList = new ArrayList<>();
		companyList.add("LG");
		companyList.add("Samsung");
		companyList.add("Hyundai");*/
		
		//�迭�� ó���ϴ� Ŭ����(Arrays)
		List<String> companyList = Arrays.asList("LG", "Samsung", "Hyundai");
		
		for(String company : companyList) {
			System.out.println(company);
		}
		System.out.println("===================");
		//Stream Ŭ���� - ���ٽ����� ����
		Stream<String> stream = companyList.stream();
		stream.forEach(company -> System.out.println(company));
	}
}
