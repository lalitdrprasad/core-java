package com.study.java8;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamDemo1 {

	public static void main(String[] args) {

		IntStream stream = IntStream.generate(() -> new Random().nextInt(1000)).limit(20);

		stream.filter(number -> number % 2 == 0).forEach(number -> System.out.println(number));

	}
}
