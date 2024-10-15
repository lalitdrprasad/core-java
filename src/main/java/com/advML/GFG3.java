package com.advML;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GFG3 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(4);
		list.add(76);
		list.add(21);
		list.add(3);
		list.add(80);

		Stream<Integer> stream = list.stream();

		List<Integer> numbers = stream.filter(number -> number % 2 == 0).filter(number -> number > 20)
				.collect(Collectors.toList());

		numbers.forEach(System.out::println);
	}
}
