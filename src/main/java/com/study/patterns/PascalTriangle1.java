package com.study.patterns;

import java.util.Random;

public class PascalTriangle1 {

	static void print(int n) {

		int rows = n;
		int cols = n * 2 - 1;
		int tmp = 0;

		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);

		for (int i = 0; i < rows; i++) {
			System.out.printf("Row - %2d : ", i);

			for (int space = 1; space <= rows - i; space++)
				System.out.printf("  ");
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == 0)
					tmp = 1;
				else
					tmp = tmp * (i - j + 1) / j;

				System.out.printf("%4d", tmp);
			}
			System.out.printf("\n");
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(15));
	}
}
