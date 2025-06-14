package com.study.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class StreamOperations {

	public static void main(String[] args) {
		Random random = new Random();

		Integer[] numbers = new Integer[10];

		for (int i = 0; i < 10; i++) {
			numbers[i] = random.nextInt(1, 20);
			System.out.print(numbers[i] + "\t");
		}

		System.out
				.println("\n\nMultiplication of all : " + Arrays.stream(numbers).reduce(1, (a, b) -> a * b).intValue());
		
		System.out.println(
				"4th Laargest: " + Arrays.stream(numbers).sorted(Comparator.reverseOrder()).skip(3).findFirst().get());
	}
}
