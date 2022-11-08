package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		//Arrays 클래스 이용
		List<Student> list = Arrays.asList(
				new Student("콩쥐", 90),
				new Student("팥쥐", 70),
				new Student("심청", 80)
		);
		
		//스트림 객체 얻기
		Stream<Student> stream = list.stream();
		stream.forEach(student -> {
			String name = student.getName();
			int score = student.getScore();
			System.out.println(name + " " + score);
		});
		
		//map() 함수: 일치하는 내용 처리 - 학생의 이름
		stream = list.stream();		//stream 객체는 1회용이므로(소모) 다시 생성
		stream.map(std -> std.getName())
				.forEach(s -> System.out.println(s));
		
		//학생의 점수 출력
		stream = list.stream();
		stream.mapToInt(std -> std.getScore())
				.forEach(s -> System.out.println(s));
		
		//조건 처리 - filter() 사용
		list.stream().filter(std -> std.getScore() > 80)
						.map(std -> std.getName())
						.forEach(s -> System.out.println(s));
	}
}
