package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class OptionalDemo {
	private static Optional<List<Integer>> optional;

	public static Optional<String> getElement(int n) {

		Optional<String> opt = null;

		if (optional.isPresent()) {
			List<Integer> list = optional.get();
			if (list.contains(n)) {
				opt = Optional.of(n + " Is Present");
			} else
				opt = Optional.ofNullable(null);
		} else
			opt = Optional.ofNullable(null);
		return opt;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			list.add(new Random().nextInt(50));
		}

		optional = Optional.of(list);
		optional.ifPresent(n -> System.out.println(n));

		// optional = optional.empty();

		// list = null;
		// optional = Optional.ofNullable(list);

		for (int i = 0; i < 20; i++) {

			Optional<String> optional1 = getElement(new Random().nextInt(50));

			// optional1.ifPresent(tmp -> System.out.println(tmp));

			System.out.println(optional1.orElse("False"));
			
			// if (optional1.isPresent()) {
			// System.out.println(optional1.get());
			// }
		}

	}

}
