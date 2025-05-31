package com.study.patterns;

import java.util.Random;

public class Butterfly {

	static void print(int n) {
		int rows = n;
		int cols = n;
		System.out.println("Rows = " + rows);
		System.out.println("Cols = " + cols);

		for (int i = 1; i <= rows; i++) {
			System.out.printf("Row - %2d : ", i);
			for (int j = 1; j <= cols; j++) {
				if (i <=rows / 2 && (i >= j || j > rows - i % rows))
					System.out.print("*");
				else if ((i < j) && i >= rows / 2)
					System.out.print("*");
				else if ((i + j <= rows) && i >= rows / 2)
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
