package com.study.patterns;

import java.util.Random;

public class Triangle4 {
	static void print(int n) {

		int rows = n * 2;
		int cols = n;

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i + j <= rows && i >= j)
					System.out.print("*  ");
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}

	public static void main(String[] args) {
		print(new Random().nextInt(20));
		// print(5);
	}
}
