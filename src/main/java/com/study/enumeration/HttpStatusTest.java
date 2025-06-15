package com.study.enumeration;

import java.util.Arrays;

public class HttpStatusTest {

	public static void main(String[] args) {

		HttpStatus[] statuses = HttpStatus.values();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("STATUS\t\t\tCODE\tDESCRIPTION");
		System.out.println("--------------------------------------------------------------------------");
		Arrays.stream(statuses).forEach(status -> {
			System.out
					.println(String.format("%-18s\t%d\t%s", status.name(), status.getCode(), status.getDescription()));
		});
		System.out.println("--------------------------------------------------------------------------");

	}

}
