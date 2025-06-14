package com.study.streams;

import java.util.stream.Collectors;

public class RemoveDuplicate {
	public static <R> void main(String[] args) {
		String input = "programming";

		String result = input.
				chars().
				distinct().
				mapToObj(c -> ""+(char)c).
				collect(Collectors.joining());

		System.out.println(result);

	}

}
