package com.study.java8;

import java.util.Arrays;
import java.util.Random;

public class EvenOddUsingStream {

	public static void main(String[] args) {

		int limit = 22;
		Random random = new Random();

		Integer[] ar = new Integer[limit];
		System.out.print("All Numbers");
		for (int beg = 0; beg < limit; beg++) {
			if (beg % 10 == 0)
				System.out.println();
			ar[beg] = random.nextInt(1, 100);
			System.out.print(ar[beg] + "\t");

		}

		System.out.println("\n\nEven Numbers");
		Arrays.stream(ar).filter(number -> number % 2 == 0).forEach(number -> System.out.print(number + "\t"));

		System.out.println("\n\nOdd Numbers");
		Arrays.stream(ar).filter(number -> number % 2 != 0).forEach(number -> System.out.print(number + "\t"));

	}
}
