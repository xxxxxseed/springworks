package streamex;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		List<Customer> customerList = new ArrayList<>();
		
		Customer lee = new Customer("�̼���", 40, 100);
		Customer kang = new Customer("������", 10, 100);
		Customer hong = new Customer("ȫ�浿", 15, 50);
		
		customerList.add(lee);
		customerList.add(kang);
		customerList.add(hong);
		
		System.out.println("=== ����� �߰��� ������� ��� ===");
		customerList.stream().map(c -> c.getName())
								.forEach(s -> System.out.println(s));
		
		int total = customerList.stream().mapToInt(c -> c.getPrice())
											.sum();
		System.out.println("�� ���� ����� : " + total + "�Դϴ�.");
		System.out.println("=== 20�� �̻� �� ��� �����Ͽ� ��� ===");
		customerList.stream().filter(c -> c.getAge() >= 20)
								.map(c -> c.getName())
								.sorted()
								.forEach(s -> System.out.println(s));
	}
}
