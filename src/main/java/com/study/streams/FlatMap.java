package com.study.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMap {
	public static void main(String[] args) {
		List<Student> studentList1 = new ArrayList<Student>();
		studentList1.add(new Student("Smith", 101, 'A', 550));
		studentList1.add(new Student("John", 102, 'B', 400));
		studentList1.add(new Student("Kenedy", 103, 'C', 342));

		List<Student> studentList2 = new ArrayList<Student>();
		studentList2.add(new Student("Scott", 104, 'A', 522));
		studentList2.add(new Student("Mary", 105, 'B', 435));
		studentList2.add(new Student("Kitty", 106, 'C', 312));

		List<List<Student>> studentList = Arrays.asList(studentList1, studentList2);

		List<Student> studentListByGrade = studentList.stream().flatMap(list -> list.stream())
				.sorted((s1, s2) -> s1.getGrade() > s2.getGrade() ? 1 : -1).collect(Collectors.toList());

		System.out.println(studentListByGrade);

		Optional<Student> firstClass = studentList.stream().flatMap(list -> list.stream())
				.max((s1, s2) -> s1.getMarks() > s2.getMarks() ? 1 : -1);

		System.out.println(firstClass.get().getMarks());

	}
}
