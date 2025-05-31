package com.study.comparator;

import java.util.ArrayList;
import java.util.Random;

public class ComparatorDemo {
	public static void main(String[] args) {

		Random random = new Random();
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {

			students.add(
					new Student(
							random.nextInt(10000, 1000000), 
							"Student" + random.nextInt(10, 99),
							random.nextInt(0, 100)
							)
					);
		}

		System.out.println("Default Order");
		students.forEach(System.out::println);

		System.out.println("Sorted Order");
		students.stream().sorted((Student s1, Student s2) -> s1.marks > s2.marks ? 1 : -1).forEach(System.out::println);
	}

}
