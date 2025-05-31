package com.study.patterns;

import java.util.Random;

public class KiteInSquare {

	static void print(int n) {
		int rows = n * 4;
		int cols = n * 4;
		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);
		for (int i = 1; i <= rows / 2; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i + j <= rows / 2 + 1 || j >= rows / 2 + i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		for (int i = 1; i <= rows / 2; i++) {
			for (int j = 1; j <= cols; j++) {
				if (i >= j || i + j > rows)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(3,8));
		// print(5);
	}

}
