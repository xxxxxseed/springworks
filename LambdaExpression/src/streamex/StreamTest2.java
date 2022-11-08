package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		//Arrays Ŭ���� �̿�
		List<Student> list = Arrays.asList(
				new Student("����", 90),
				new Student("����", 70),
				new Student("��û", 80)
		);
		
		//��Ʈ�� ��ü ���
		Stream<Student> stream = list.stream();
		stream.forEach(student -> {
			String name = student.getName();
			int score = student.getScore();
			System.out.println(name + " " + score);
		});
		
		//map() �Լ�: ��ġ�ϴ� ���� ó�� - �л��� �̸�
		stream = list.stream();		//stream ��ü�� 1ȸ���̹Ƿ�(�Ҹ�) �ٽ� ����
		stream.map(std -> std.getName())
				.forEach(s -> System.out.println(s));
		
		//�л��� ���� ���
		stream = list.stream();
		stream.mapToInt(std -> std.getScore())
				.forEach(s -> System.out.println(s));
		
		//���� ó�� - filter() ���
		list.stream().filter(std -> std.getScore() > 80)
						.map(std -> std.getName())
						.forEach(s -> System.out.println(s));
	}
}
