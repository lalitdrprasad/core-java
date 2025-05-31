package com.study.patterns;

import java.util.Random;

public class Matrix {

	static void print(int n) {
		int rows = n * 2 - 1;
		int cols = n;
		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);

		for (int i = 1; i <= rows; i++) {
			System.out.printf("Row - %2d : ", i);
			for (int j = 1; j <= cols; j++) {
				System.out.printf("%4d-%d", i, j);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(10));
	}
}
