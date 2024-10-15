package com.advML;

import java.util.*;
import java.util.stream.Stream;

public class GFG2 {

	public static void main(String[] args) {

		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		Stream<Integer> streamOfNumbers = Arrays.stream(numbers);

		long evenNumbersStream = streamOfNumbers.filter(number -> number % 3 == 0).count();

		System.out.println(evenNumbersStream);
	}
}
