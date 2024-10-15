package com.patterns;

import java.util.Random;

public class UpDownTriangle {
	static void print(int n) {
		int rows = n/2;
		int cols = rows * 2 - 1;
		System.out.println("Rows = " + n);
		System.out.println("Cols = " + cols);

		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= cols; j++) {
				if (j >= i && j <= cols - i + 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= cols; j++) {
				if (j > rows - i && j < rows + i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(new Random().nextInt(40));
		// print(15);
	}
}
