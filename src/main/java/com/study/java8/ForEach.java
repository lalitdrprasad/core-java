package com.study.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ForEach {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			list.add(new Random().nextInt(91) + 9);
		}

		// method reference
		// list.forEach(System.out::println);

		// Lambda expression
		// list.forEach(n -> System.out.print(n + " "));
		// System.out.println();

		// Consumer Anonymous Inner Class 
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer n) {
				System.out.println(n);
			}
		});
	}
}
